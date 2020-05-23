//
//  Pokemon.swift
//  Personal Pokedex
//
//  Created by Caleb Johnson on 5/15/20.
//  Copyright © 2020 Caleb Johnson. All rights reserved.
//

import Foundation

class Pokemon : Codable {
    var SpeciesID:Int = 0
    var SpeciesPokemonName:String = ""
    var SpeciesSpriteUrl:String = ""
    var SpecieseImageUrl:String = ""
    var SpeciesName:String = ""
    var SpeciesType1:String = ""
    var SpeciesType2:String = ""
    var SpeciesHeight:String = ""
    var SpeciesWeight:String = ""
    var SpeciesText:String = ""
    var SpeciesBaseHp:Int = 0
    var SpeciesBaseAttack:Int = 0
    var SpeciesBaseDefense:Int = 0
    var SpeciesBaseSpecial:Int = 0
    var SpeciesBaseSpeed:Int = 0
    var TrainerID:Int = 0
    var CaughtPokemonSex:String = ""
    var CaughtPokemonLevel:Int = 0
    var CaughtPokemonNickname:String = ""
    var CaughtPokemonID1:Int = 0
    var CaughtPokemonID2:Int = 0
    var CaughtPokemonID3:Int = 0
    var CaughtPokemonID4:Int = 0
}
