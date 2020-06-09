//
//  Scroll.swift
//  Personal Pokedex
//
//  Created by Caleb Johnson on 5/15/20.
//  Copyright © 2020 Caleb Johnson. All rights reserved.
//

import UIKit

class Scroll: UIViewController {
    @IBOutlet weak var pokedexName: UILabel!
    var poke = Pokemon()
    var currPoke = Pokemon()
    var pokersMoves = [MoveResponse]()
    var pokers:[Pokemon] = [Pokemon]()
    var party:[Pokemon] = [Pokemon]()
    @IBAction func addPokemon(_ sender: Any) {
    }
    @IBOutlet weak var totalCaught: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
        party = DataCache.shared.pokers
        pokeBack.backgroundColor = UIColor(red: 179.0/255.0, green: 4.1/255.0, blue: 23.3/255.0, alpha: 0.8)
        pokeBack.layer.cornerRadius = 5
        pokeBack.layer.borderWidth = 2
        var count = 0
        print("count 'em ", party.count)
        totalCaught.text = "Caught: " + String(party.count) + "/151"
        print(count)
        print(party[0].SpeciesName)
        for i in 1...151 {
            if (party[count].SpeciesID == i) {
                pokers.append(party[count])
                if (count+1 < party.count) {
                    count += 1
                }
            } else {
                pokers.append(Pokemon())
            }
            
        }
        
        //poker.SpeciesName = "Blastoise"
        // Do any additional setup after loading the view.
    }
    @IBOutlet weak var pokeBack: UIImageView!
    
    func getData(from url: URL, completion: @escaping (Data?, URLResponse?, Error?) -> ()) {
        URLSession.shared.dataTask(with: url, completionHandler: completion).resume()
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "toProfile" {
            let main = segue.destination as! PokemonProfile
            main.poke = self.currPoke
            main.moves = self.pokersMoves
        }
    }


}



extension Scroll: UITableViewDataSource, UITableViewDelegate {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        print(pokers.count)
        return pokers.count;
    }
    
    
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let poke:Pokemon = pokers[indexPath.row]
        //let greenish = UIColor(red:230.0/255.0, green: 161.0/255.0, blue: 87.0/255.0, alpha:1.0)

        let cell = tableView.dequeueReusableCell(withIdentifier: "pokeCell") as! PokeCell
        cell.we.text = poke.SpeciesPokemonName
        cell.pokeNum.text = String(format: "%03d", indexPath.row+1)
        if (poke.SpeciesSpriteUrl != "") {
            let url = URL(string: "http://" + poke.SpeciesSpriteUrl)
            self.getData(from: url!) { data, response, error in
                guard let data = data, error == nil else { return }
                DispatchQueue.main.async() {
                    cell.pokeImg.image = UIImage(data: data)
                }
                
            }
        }
        else {
            cell.we.text = "- - - - - -"
            cell.pokeImg.image = UIImage(named: "pokeball-2")
        }
        return cell
        

    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        currPoke = pokers[indexPath.row]
        let moves = GetMovesRequest()
        moves.MoveID1 = currPoke.CaughtPokemonID1
        moves.MoveID2 = currPoke.CaughtPokemonID2
        moves.MoveID3 = currPoke.CaughtPokemonID3
        moves.MoveID4 = currPoke.CaughtPokemonID4
        

        getPokemonMoves(request: moves) {
            responseData in
                    let jsonString = String(data: responseData, encoding: .utf8)!
            print(jsonString)
                  let jsonDecoder = JSONDecoder()
                  do {
                    self.pokersMoves = try jsonDecoder.decode([MoveResponse].self, from: responseData)

        
                      DispatchQueue.main.async {
                            self.performSegue(withIdentifier: "toProfile", sender: nil)

                     }
                  } catch {
                      print("how sad")
                  }
              }
    }

}

func addTrainerPokemon(request:Trainer, completionHandler: @escaping (Data) -> ()) {
    let jsonEncoder = JSONEncoder()
    var jsonData:Data = Data()
    do {
        jsonData = try jsonEncoder.encode(request)
    }
    catch {
    }
    
    let todosEndpoint: String = "http://" + DataCache.shared.serverHost + ":" + DataCache.shared.serverPort + "/add/trainer/pokemon"
    guard let todosURL = URL(string: todosEndpoint) else {
      print("Error: cannot create URL")
      return
    }
    
    var todosUrlRequest = URLRequest(url: todosURL)
    todosUrlRequest.httpMethod = "POST"
    todosUrlRequest.httpBody = jsonData

    let session = URLSession.shared
    let task = session.dataTask(with: todosUrlRequest) {
      (data, response, error) in
      guard error == nil else {
        print("error calling POST on /todos/1")
        print(error!)
        return
      }
      guard let responseData = data else {
        print("Error: did not receive data")
        return
      }

      // parse the result as JSON, since that's what the API provides
      do {
        completionHandler(responseData)
    
      }
    }
    task.resume()
}

func getPokemonMoves(request:GetMovesRequest, completionHandler: @escaping (Data) -> ()) {
    let jsonEncoder = JSONEncoder()
    var jsonData:Data = Data()
    do {
        jsonData = try jsonEncoder.encode(request)
    }
    catch {
    }
    
    let todosEndpoint: String = "http://" + DataCache.shared.serverHost + ":" + DataCache.shared.serverPort + "/get/trainer/pokemon/moves"
    guard let todosURL = URL(string: todosEndpoint) else {
      print("Error: cannot create URL")
      return
    }
    
    var todosUrlRequest = URLRequest(url: todosURL)
    todosUrlRequest.httpMethod = "POST"
    todosUrlRequest.httpBody = jsonData

    let session = URLSession.shared
    let task = session.dataTask(with: todosUrlRequest) {
      (data, response, error) in
      guard error == nil else {
        print("error calling POST on /todos/1")
        print(error!)
        return
      }
      guard let responseData = data else {
        print("Error: did not receive data")
        return
      }

      // parse the result as JSON, since that's what the API provides
      do {
        completionHandler(responseData)
    
      }
    }
    task.resume()
}




