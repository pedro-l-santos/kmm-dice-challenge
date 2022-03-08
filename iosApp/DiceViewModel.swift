//
//  DiceViewModel.swift
//  iosApp
//
//  Created by Kyber on 08/03/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

final class DiceViewModel: ObservableObject {
    @Published
    var numFaces = 4
    @Published
    var diceValue = 0
    
    // KMM RandomAPI Repo
    private let kmmRandomRepo = RandomRepository()
    
    func rollDice(){
        kmmRandomRepo.rollDice(numFaces: Int32(numFaces)){value,_ in
            if let value = value {
                self.diceValue = Int(truncating: value)
            }
        }
    }
}
