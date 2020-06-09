//
//  PickMoves.swift
//  Personal Pokedex
//
//  Created by Caleb Johnson on 5/25/20.
//  Copyright © 2020 Caleb Johnson. All rights reserved.
//

import UIKit

class PickMoves : UIViewController {
    var poke = AddPokemonRequest()
    var count = 0
    var highlights:[Int] = [Int]()
    var moves:[PossibleMoves] = [PossibleMoves]()
    @IBOutlet weak var moveText: UILabel!
    @IBAction func addPokemonAct(_ sender: Any) {
        if count > 0  {
            poke.CaughtPokemonMoveID1 = moves[highlights[0]].MoveID
            print(moves[highlights[0]].MoveName)
        }
        if count > 1 {
            poke.CaughtPokemonMoveID2 = moves[highlights[1]].MoveID
            print(moves[highlights[1]].MoveName)
        }
        if count > 2 {
            poke.CaughtPokemonMoveID3 = moves[highlights[2]].MoveID
            print(moves[highlights[2]].MoveName)
        }
        if count > 3 {
            poke.CaughtPokemonMoveID3 = moves[highlights[3]].MoveID
            print(moves[highlights[3]].MoveName)
        }
        poke.CaughtPokemonID = Int.random(in: 0..<255000)
        poke.TrainerID = DataCache.shared.trainerNum
        self.performSegue(withIdentifier: "fromAdd", sender: nil)
        addCaughtPokemon(request: poke) {
            responseData in
            self.performSegue(withIdentifier: "fromAdd", sender: nil)
                 
              }
        
    }
    @IBOutlet weak var moveTable: UITableView!
    override func viewDidLoad() {
        moveTable.reloadData();

        
    }
}

extension PickMoves: UITableViewDataSource, UITableViewDelegate {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        print(moves.count)
        return moves.count;
    }
    
    
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let move:PossibleMoves = moves[indexPath.row]
        //let greenish = UIColor(red:230.0/255.0, green: 161.0/255.0, blue: 87.0/255.0, alpha:1.0)

        let cell = tableView.dequeueReusableCell(withIdentifier: "moveCell") as! MoveCell
        cell.moveName.text = move.MoveName
        cell.moveReq.text = move.Requirement
        cell.cellback.layer.cornerRadius = 5
        cell.cellback.layer.borderWidth = 2
        if (highlights.contains(indexPath.item)) {
            cell.cellback.backgroundColor = UIColor(red: 55.0/255.0, green: 245.0/255.0, blue: 50.0/255.0, alpha: 0.55)
            
        } else {
            cell.cellback.backgroundColor = UIColor(red: 199.0/255.0, green: 4.1/255.0, blue: 23.3/255.0, alpha: 0.55)
        }
        return cell
        

    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        if (count == 0) {
            count += 1
            highlights.append(indexPath.item)
            moveText.text = "Select Second Move"
            moveTable.reloadData()
            
        }
        else if (count == 1) {
            count += 1
            highlights.append(indexPath.item)
            moveText.text = "Select Third Move"
            moveTable.reloadData()
            
        }
        else if (count == 2) {
            count += 1
            highlights.append(indexPath.item)
            moveText.text = "Select Fourth Move"
            moveTable.reloadData()
            
        }
        else if (count == 3) {
            count += 1
            moveText.text = "Ready!"
            highlights.append(indexPath.item)
            moveTable.reloadData()
        }
        
    }

}

func addCaughtPokemon(request:AddPokemonRequest, completionHandler: @escaping (Data) -> ()) {
    let jsonEncoder = JSONEncoder()
    var jsonData:Data = Data()
    do {
        
        jsonData = try jsonEncoder.encode(request)
        let jsonString = String(data: jsonData, encoding: .utf8)!
        print(jsonString)

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





