//
//  TrainerNum.swift
//  Personal Pokedex
//
//  Created by Caleb Johnson on 5/24/20.
//  Copyright © 2020 Caleb Johnson. All rights reserved.
//

import UIKit

class TrainerNum : ViewController {
    @IBAction func view(_ sender: Any) {
        self.performSegue(withIdentifier: "viewPoke", sender: nil)
        getTrainerPokemon(request: DataCache.shared.trainerNum) { responseData in
                  let jsonDecoder = JSONDecoder()
                  do {
                    let pokers:[Pokemon] = try jsonDecoder.decode([Pokemon].self, from: responseData)
                    DataCache.shared.pokers = pokers
        
                      DispatchQueue.main.async {
                        self.performSegue(withIdentifier: "viewPoke", sender: nil)

                     }
                  } catch {
                      print("how sad")
                  }
              }
    }
    
    @IBOutlet weak var welcomeMsg: UILabel!
    
    override func viewDidLoad() {
        welcomeMsg.text = "Welcome " + DataCache.shared.trainer.TrainerName! + "!"
    }
}

func getTrainerPokemon(request:Int, completionHandler: @escaping (Data) -> ()) {
    DataCache.shared.trainerNum = request
    let jsonEncoder = JSONEncoder()
    var jsonData:Data = Data()
    do {
        jsonData = try jsonEncoder.encode(request)

    }
    catch {
    }
    
    let todosEndpoint: String = "http://" + DataCache.shared.serverHost + ":" + DataCache.shared.serverPort + "/get/trainer/pokemon"
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

