//
//  DataCache.swift
//  Personal Pokedex
//
//  Created by Caleb Johnson on 5/23/20.
//  Copyright © 2020 Caleb Johnson. All rights reserved.
//

import Foundation

class DataCache {
    static let shared = DataCache()
    var serverHost:String = "127.0.0.1"
    var serverPort:String = "8017"
    var trainerNum:Int = -1
    var trainer:Trainer = Trainer()
    var pokers:[Pokemon] = [Pokemon]()
}
