//
//  AddPokemonRequest.swift
//  Personal Pokedex
//
//  Created by Caleb Johnson on 5/25/20.
//  Copyright © 2020 Caleb Johnson. All rights reserved.
//

import Foundation

class AddPokemonRequest : Codable {
    var CaughtPokemonID:Int = 0
    var TrainerID:Int = 0
    var SpeciesID:Int = 0
    var CaughtPokemonSex:String = ""
    var CaughtPokemonLevel = 0
    var CaughtPokemonNickname = ""
    var CaughtPokemonMoveID1 = 0
    var CaughtPokemonMoveID2 = 0
    var CaughtPokemonMoveID3 = 0
    var CaughtPokemonMoveID4 = 0
}
