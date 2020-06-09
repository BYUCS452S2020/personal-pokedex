//
//  NewTrainer.swift
//  Personal Pokedex
//
//  Created by Caleb Johnson on 5/24/20.
//  Copyright © 2020 Caleb Johnson. All rights reserved.
//

import UIKit

class NewTrainer : ViewController {
    var c1:Bool = false
    var c2:Bool = false
    var c3:Bool = false
    var c4:Bool = false
    var c5:Bool = false
    var c6:Bool = false
    var c7:Bool = false
    var c8:Bool = false
    @IBOutlet weak var b8: UIImageView!
    @IBOutlet weak var b7: UIImageView!
    @IBOutlet weak var b6: UIImageView!
    @IBOutlet weak var b5: UIImageView!
    @IBOutlet weak var b4: UIImageView!
    @IBOutlet weak var b3: UIImageView!
    @IBOutlet weak var b2: UIImageView!
    @IBOutlet weak var b1: UIImageView!
    @IBOutlet weak var butBack: UIImageView!
    @IBOutlet weak var back: UIImageView!
    @IBOutlet weak var hometownField: UITextField!
    @IBOutlet weak var b1Ac: UIButton!
    @IBOutlet weak var nameField: UITextField!
    @IBOutlet weak var pickr: UISegmentedControl!
    @IBAction func register(_ sender: Any) {
        let trainerName = nameField.text!
        let trainerTown = hometownField.text!
        let sex = pickr.titleForSegment(at: pickr.selectedSegmentIndex)
        let trainer = Trainer()
        trainer.TrainerName = trainerName
        trainer.TrainerHometown = trainerTown
        trainer.TrainerSex = sex
        DataCache.shared.trainer = trainer
        self.performSegue(withIdentifier: "fromRegister", sender: nil)
        addTrainer(request: trainer) { responseData in
                  let jsonDecoder = JSONDecoder()
                  do {
                    let trainerNum = try jsonDecoder.decode(Int.self, from: responseData)
                    
                    DataCache.shared.trainerNum = trainerNum
                      DispatchQueue.main.async {
                         //self.performSegue(withIdentifier: "fromRegister", sender: nil)

                     }
                  } catch {
                      print("how sad")
                  }
              }
        
        
    }
    
    @IBAction func b1a(_ sender: Any) {
        if c1 {
            b1.backgroundColor = UIColor(red: 255/255.0, green: 255/255.0, blue: 255/255.0, alpha: 0.55)
            c1 = false
        } else {
            b1.backgroundColor = UIColor(red: 199.0/255.0, green: 4.1/255.0, blue: 23.3/255.0, alpha: 0.55)
            c1 = true
        }
    }
    @IBAction func b2a(_ sender: Any) {
        if c2 {
            b2.backgroundColor = UIColor(red: 255/255.0, green: 255/255.0, blue: 255/255.0, alpha: 0.55)
            c2 = false
        } else {
            b2.backgroundColor = UIColor(red: 199.0/255.0, green: 4.1/255.0, blue: 23.3/255.0, alpha: 0.55)
            c2 = true
        }
    }
    @IBAction func b3a(_ sender: Any) {
        if c3 {
            b3.backgroundColor = UIColor(red: 255/255.0, green: 255/255.0, blue: 255/255.0, alpha: 0.55)
            c3 = false
        } else {
            b3.backgroundColor = UIColor(red: 199.0/255.0, green: 4.1/255.0, blue: 23.3/255.0, alpha: 0.55)
            c3 = true
        }
    }
    @IBAction func b4a(_ sender: Any) {
        if c4 {
            b4.backgroundColor = UIColor(red: 255/255.0, green: 255/255.0, blue: 255/255.0, alpha: 0.55)
            c4 = false
        } else {
            b4.backgroundColor = UIColor(red: 199.0/255.0, green: 4.1/255.0, blue: 23.3/255.0, alpha: 0.55)
            c4 = true
        }
    }
    @IBAction func b5a(_ sender: Any) {
        if c5 {
            b5.backgroundColor = UIColor(red: 255/255.0, green: 255/255.0, blue: 255/255.0, alpha: 0.55)
            c5 = false
        } else {
            b5.backgroundColor = UIColor(red: 199.0/255.0, green: 4.1/255.0, blue: 23.3/255.0, alpha: 0.55)
            c5 = true
        }
    }
    @IBAction func b6a(_ sender: Any) {
        if c6 {
            b6.backgroundColor = UIColor(red: 255/255.0, green: 255/255.0, blue: 255/255.0, alpha: 0.55)
            c6 = false
        } else {
            b6.backgroundColor = UIColor(red: 199.0/255.0, green: 4.1/255.0, blue: 23.3/255.0, alpha: 0.55)
            c6 = true
        }
    }
    
    @IBAction func b7a(_ sender: Any) {
        if c7 {
            b7.backgroundColor = UIColor(red: 255/255.0, green: 255/255.0, blue: 255/255.0, alpha: 0.55)
            c7 = false
        } else {
            b7.backgroundColor = UIColor(red: 199.0/255.0, green: 4.1/255.0, blue: 23.3/255.0, alpha: 0.55)
            c7 = true
        }
    }
    @IBAction func b8a(_ sender: Any) {
        if c8 {
            b8.backgroundColor = UIColor(red: 255/255.0, green: 255/255.0, blue: 255/255.0, alpha: 0.55)
            c8 = false
        } else {
            b8.backgroundColor = UIColor(red: 199.0/255.0, green: 4.1/255.0, blue: 23.3/255.0, alpha: 0.55)
            c8 = true
        }
    }
    override func viewDidLoad() {
        butBack.backgroundColor = UIColor(red: 199.0/255.0, green: 4.1/255.0, blue: 23.3/255.0, alpha: 0.55)
        butBack.layer.cornerRadius = 5
        butBack.layer.borderWidth = 2
        back.layer.borderWidth = 2
        b1.layer.borderWidth = 2
        b1.layer.cornerRadius = 5
        b2.layer.borderWidth = 2
        b2.layer.cornerRadius = 5
        b3.layer.borderWidth = 2
        b3.layer.cornerRadius = 5
        b4.layer.borderWidth = 2
        b4.layer.cornerRadius = 5
        b5.layer.borderWidth = 2
        b5.layer.cornerRadius = 5
        b6.layer.borderWidth = 2
        b6.layer.cornerRadius = 5
        b7.layer.borderWidth = 2
        b7.layer.cornerRadius = 5
        b8.layer.borderWidth = 2
        b8.layer.cornerRadius = 5
        back.backgroundColor = UIColor(red: 199.0/255.0, green: 4.1/255.0, blue: 23.3/255.0, alpha: 0.55)
    }
}

func addTrainer(request:Trainer, completionHandler: @escaping (Data) -> ()) {
    let jsonEncoder = JSONEncoder()
    var jsonString:String
    var jsonData:Data = Data()
    do {
        jsonData = try jsonEncoder.encode(request)
        jsonString = String(data: jsonData, encoding: .utf8)!
    }
    catch {
    }
    
    let todosEndpoint: String = "http://" + DataCache.shared.serverHost + ":" + DataCache.shared.serverPort + "/add/trainer"
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

