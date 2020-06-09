//
//  MoveID.swift
//  Personal Pokedex
//
//  Created by Caleb Johnson on 5/15/20.
//  Copyright © 2020 Caleb Johnson. All rights reserved.
//

import UIKit

class MoveID : UIViewController {
    @IBOutlet weak var back: UIImageView!
    var move:MoveResponse = MoveResponse()
    @IBOutlet weak var moveName: UILabel!
    @IBOutlet weak var moveText: UILabel!
    @IBOutlet weak var moveType: UILabel!
    @IBOutlet weak var moveBase: UILabel!
    @IBOutlet weak var movePP: UILabel!
    @IBOutlet weak var moveAccuracy: UILabel!
    override func viewDidLoad() {
        back.backgroundColor = UIColor(red: 199.0/255.0, green: 4.1/255.0, blue: 23.3/255.0, alpha: 0.75)
        back.layer.borderWidth = 3
        moveName.text = move.MoveName
        moveText.text = move.MoveText
        movePP.text = String(move.MovePP)
        moveType.text = move.MoveType
        moveBase.text = String(move.MoveBase)
        moveAccuracy.text = String(move.MoveAccuracy) + "%"
        
        
    }
}
