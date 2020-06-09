//
//  MoveResponse.swift
//  Personal Pokedex
//
//  Created by Caleb Johnson on 5/25/20.
//  Copyright © 2020 Caleb Johnson. All rights reserved.
//

import Foundation

class MoveResponse : Codable {
    var MoveID:Int = 0
    var MoveBase:Int = 0
    var MovePP:Int = 0
    var MoveAccuracy:Int = 0
    var MoveType:String = ""
    var MoveName:String = ""
    var MoveText:String = ""
    var Requirement = ""
}
