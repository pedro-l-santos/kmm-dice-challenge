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
    var diceValue = DiceManager().rollDice(numFaces: 4)
    
    func rollDice(){
        diceValue = DiceManager().rollDice(numFaces: Int32(numFaces))
    }
}
