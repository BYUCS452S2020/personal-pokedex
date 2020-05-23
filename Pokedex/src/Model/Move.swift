//
//  Move.swift
//  Personal Pokedex
//
//  Created by Caleb Johnson on 5/15/20.
//  Copyright © 2020 Caleb Johnson. All rights reserved.
//

import Foundation

class Move : Codable {
    var MoveID:Int = -1
    var MoveName:String = ""
    var MoveType:String = ""
    var MoveText:String = ""
    var MovePP:String = ""
    var MoveBase:String = ""
    var MoveAccuracy:String = ""
}
