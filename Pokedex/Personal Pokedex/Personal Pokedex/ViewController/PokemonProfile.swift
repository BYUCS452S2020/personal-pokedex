//
//  PokemonProfile.swift
//  Personal Pokedex
//
//  Created by Caleb Johnson on 5/15/20.
//  Copyright © 2020 Caleb Johnson. All rights reserved.
//

import UIKit

class PokemonProfile : UIViewController {
    var poke:Pokemon = Pokemon()
    var currMove:MoveResponse = MoveResponse()
    var moves:[MoveResponse] = [MoveResponse]()
    @IBOutlet weak var pokeImg: UIImageView!
    @IBOutlet weak var pokeName: UILabel!
    @IBOutlet weak var pokeNick: UILabel!
    @IBOutlet weak var pokeLvl: UILabel!
    @IBOutlet weak var pokeHeight: UILabel!
    @IBOutlet weak var pokeWeight: UILabel!
    @IBOutlet weak var move1: UILabel!
    @IBOutlet weak var move2: UILabel!
    @IBOutlet weak var move3: UILabel!
    @IBOutlet weak var move4: UILabel!
    @IBOutlet weak var pokeColor: UIImageView!
    @IBOutlet weak var pokeTxt: UILabel!
    @IBOutlet weak var type1: UILabel!
    @IBOutlet weak var type2: UILabel!
    @IBOutlet weak var pkBack: UIImageView!
    @IBOutlet weak var pkSex: UILabel!
    @IBOutlet weak var pkHp: UILabel!
    @IBOutlet weak var pkAtk: UILabel!
    @IBOutlet weak var pkDef: UILabel!
    @IBOutlet weak var pkSpec: UILabel!
    @IBOutlet weak var pkSpeed: UILabel!
    @IBAction func move1Act(_ sender: Any) {
        currMove = moves[0]
        performSegue(withIdentifier: "move", sender: nil)
    }
    @IBAction func move2Act(_ sender: Any) {
        currMove = moves[1]
        performSegue(withIdentifier: "move", sender: nil)
    }
    @IBAction func move3Act(_ sender: Any) {
        currMove = moves[2]
        performSegue(withIdentifier: "move", sender: nil)
    }
    @IBAction func move4Act(_ sender: Any) {
        currMove = moves[3]
        performSegue(withIdentifier: "move", sender: nil)
    }
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "move" {
            let main = segue.destination as! MoveID
            main.move = self.currMove
        }
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        let url = URL(string: "http://" + poke.SpeciesSpriteUrl)
        pokeName.text = poke.SpeciesPokemonName
        pokeNick.text = poke.CaughtPokemonNickname.replacingOccurrences(of: "\"", with: "", options: NSString.CompareOptions.literal, range: nil)
        pokeLvl.text = String(poke.CaughtPokemonLevel)
        pokeHeight.text = poke.SpeciesHeight.replacingOccurrences(of: "\"", with: "", options: NSString.CompareOptions.literal, range: nil)
        pokeWeight.text = poke.SpeciesWeight
        pokeColor.layer.borderWidth = 4
        if moves.count > 0 {
            move1.text = moves[0].MoveName
        }
        if moves.count > 1 {
            move2.text = moves[1].MoveName
        }
        if moves.count > 2 {
            move3.text = moves[2].MoveName
        }
        if moves.count > 3 {
            move4.text = moves[3].MoveName
        }
        move1.layer.borderWidth = 2
        move1.backgroundColor = UIColor(red: 199.0/255.0, green: 4.1/255.0, blue: 23.3/255.0, alpha: 0.75)
        //move1.layer.cornerRadius = 4
        move2.layer.borderWidth = 2
        //move2.layer.cornerRadius = 4
        move2.backgroundColor = UIColor(red: 199.0/255.0, green: 4.1/255.0, blue: 23.3/255.0, alpha: 0.75)
        move3.layer.borderWidth = 2
        //move3.layer.cornerRadius = 4
        move3.backgroundColor = UIColor(red: 199.0/255.0, green: 4.1/255.0, blue: 23.3/255.0, alpha: 0.75)
        move4.layer.borderWidth = 2
        //move4.layer.cornerRadius = 4
        move4.backgroundColor = UIColor(red: 199.0/255.0, green: 4.1/255.0, blue: 23.3/255.0, alpha: 0.75)
        pkBack.layer.borderWidth = 3
        pkBack.layer.cornerRadius = 4
        type1.text = poke.SpeciesType1
        type2.text = poke.SpeciesType2
        pokeTxt.text = poke.SpeciesText
        pkSex.text = poke.CaughtPokemonSex
        pkHp.text = String(poke.SpeciesBaseHp)
        pkAtk.text = String(poke.SpeciesBaseAttack)
        pkDef.text = String(poke.SpeciesBaseDefense)
        pkSpec.text = String(poke.SpeciesBaseSpecial)
        pkSpeed.text = String(poke.SpeciesBaseSpeed)
        pokeColor.backgroundColor = UIColor(red: 199.0/255.0, green: 4.1/255.0, blue: 23.3/255.0, alpha: 0.75)
        self.getData(from: url!) { data, response, error in
            guard let data = data, error == nil else { return }
            DispatchQueue.main.async() {
                self.pokeImg.image = UIImage(data: data)
            }
            
        }

        
    }
    
    func getData(from url: URL, completion: @escaping (Data?, URLResponse?, Error?) -> ()) {
          URLSession.shared.dataTask(with: url, completionHandler: completion).resume()
      }
}
