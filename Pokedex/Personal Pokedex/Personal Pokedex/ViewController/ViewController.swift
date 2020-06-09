//
//  ViewController.swift
//  Personal Pokedex
//
//  Created by Caleb Johnson on 5/15/20.
//  Copyright © 2020 Caleb Johnson. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    var poker:Pokemon = Pokemon()
    @IBOutlet weak var mainPokeBack: UIImageView!
    @IBOutlet weak var name: UITextField!
    @IBAction func push(_ sender: Any) {

        getTrainerPokemon(request: Int(name.text!) ?? 1) {
            responseData in
                    let jsonString = String(data: responseData, encoding: .utf8)!
            print(jsonString)
                  let jsonDecoder = JSONDecoder()
                  do {
                    let pokers:[Pokemon] = try jsonDecoder.decode([Pokemon].self, from: responseData)
                    DataCache.shared.pokers = pokers
        
                      DispatchQueue.main.async {
                        self.performSegue(withIdentifier: "viewScroll", sender: nil)

                     }
                  } catch {
                      print("how sad")
                  }
              }
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        poker.SpeciesName = "Blastoise"
        
        // Do any additional setup after loading the view.
    }


}

