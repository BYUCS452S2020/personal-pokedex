//
//  PickPokemon.swift
//  Personal Pokedex
//
//  Created by Caleb Johnson on 5/16/20.
//  Copyright © 2020 Caleb Johnson. All rights reserved.
//

import UIKit
class PickPokemon : UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {
    var newPoke = AddPokemonRequest()
    var possibles:[PossibleMoves] = [PossibleMoves]()
    let choices = ["001 Bulbasaur","002 Ivysaur","003 Venusaur","004 Charmander","005 Charmeleon","006 Charizard","007 Squirtle","008 Wartortle","009 Blastoise","010 Caterpie","011 Metapod","012 Butterfree","013 Weedle","014 Kakuna","015 Beedrill","016 Pidgey","017 Pidgeotto","018 Pidgeot","019 Rattata","020 Raticate","021 Spearow","022 Fearow","023 Ekans","024 Arbok","025 Pikachu","026 Raichu","027 Sandshrew","028 Sandslash","029 Nidoran♀","030 Nidorina","031 Nidoqueen","032 Nidoran♂","033 Nidorino","034 Nidoking","035 Clefairy","036 Clefable","037 Vulpix","038 Ninetales","039 Jigglypuff","040 Wigglytuff","041 Zubat","042 Golbat","043 Oddish","044 Gloom","045 Vileplume","046 Paras","047 Parasect","048 Venonat","049 Venomoth","050 Diglett","051 Dugtrio","052 Meowth","053 Persian","054 Psyduck","055 Golduck","056 Mankey","057 Primeape","058 Growlithe","059 Arcanine","060 Poliwag","061 Poliwhirl","062 Poliwrath","063 Abra","064 Kadabra","065 Alakazam","066 Machop","067 Machoke","068 Machamp","069 Bellsprout","070 Weepinbell","071 Victreebel","072 Tentacool","073 Tentacruel","074 Geodude","075 Graveler","076 Golem","077 Ponyta","078 Rapidash","079 Slowpoke","080 Slowbro","081 Magnemite","082 Magneton","083 Farfetch'd","084 Doduo","085 Dodrio","086 Seel","087 Dewgong","088 Grimer","089 Muk","090 Shellder","091 Cloyster","092 Gastly","093 Haunter","094 Gengar","095 Onix","096 Drowzee","097 Hypno","098 Krabby","099 Kingler","100 Voltorb","101 Electrode","102 Exeggcute","103 Exeggutor","104 Cubone","105 Marowak","106 Hitmonlee","107 Hitmonchan","108 Lickitung","109 Koffing","110 Weezing","111 Rhyhorn","112 Rhydon","113 Chansey","114 Tangela","115 Kangaskhan","116 Horsea","117 Seadra","118 Goldeen","119 Seaking","120 Staryu","121 Starmie","122 Mr. Mime","123 Scyther","124 Jynx","125 Electabuzz","126 Magmar","127 Pinsir","128 Tauros","129 Magikarp","130 Gyarados","131 Lapras","132 Ditto","133 Eevee","134 Vaporeon","135 Jolteon","136 Flareon","137 Porygon","138 Omanyte","139 Omastar","140 Kabuto","141 Kabutops","142 Aerodactyl","143 Snorlax","144 Articuno","145 Zapdos","146 Moltres","147 Dratini","148 Dragonair","149 Dragonite","150 Mewtwo","151 Mew"]
    @IBOutlet weak var sexBut: UISegmentedControl!
    @IBOutlet weak var picker: UIPickerView!
    @IBOutlet weak var pokeBack: UIImageView!
    @IBOutlet weak var lvlTxt: UILabel!
    @IBOutlet weak var slider: UISlider!
    @IBOutlet weak var nik: UITextField!
    @IBAction func sliderAct(_ sender: UISlider) {
        let currentVal = Int(sender.value)
        lvlTxt.text = "Current Level: \(currentVal)"
    }
    @IBAction func submitPoke(_ sender: Any) {
        
        newPoke.SpeciesID = picker.selectedRow(inComponent: 0)+1
        newPoke.CaughtPokemonLevel = Int(slider.value)
        newPoke.CaughtPokemonSex = sexBut.titleForSegment(at: sexBut.selectedSegmentIndex) ?? "Male"
        newPoke.CaughtPokemonNickname = nik.text ?? "Bill"
        getPossibleMoves(request: newPoke.SpeciesID) {
            responseData in
                    let jsonString = String(data: responseData, encoding: .utf8)!
            print(jsonString)
                  let jsonDecoder = JSONDecoder()
                  do {
                    self.possibles = try jsonDecoder.decode([PossibleMoves].self, from: responseData)

        
                      DispatchQueue.main.async {
                            self.performSegue(withIdentifier: "pickMoves", sender: nil)

                     }
                  } catch {
                      print("how sad")
                  }
              }
        
    }
    override func viewDidLoad() {
        pokeBack.layer.borderWidth = 2
        pokeBack.backgroundColor = UIColor(red: 199.0/255.0, green: 4.1/255.0, blue: 23.3/255.0, alpha: 0.75)
    }
    
     override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "pickMoves" {
            let pickMoves = segue.destination as! PickMoves
            pickMoves.poke = newPoke
            pickMoves.moves = self.possibles
        }
    }
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        1
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return choices[row]
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return choices.count
    }
}

func getPossibleMoves(request:Int, completionHandler: @escaping (Data) -> ()) {
    let jsonEncoder = JSONEncoder()
    var jsonData:Data = Data()
    do {
        jsonData = try jsonEncoder.encode(request)
    }
    catch {
    }
    
    let todosEndpoint: String = "http://" + DataCache.shared.serverHost + ":" + DataCache.shared.serverPort + "/get/pokemon/moves"
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
