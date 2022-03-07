//
//  APIView.swift
//  iosApp
//
//  Created by Kyber on 07/03/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct APIView: View {
    @State
    var data = API().getData()
    
    var body: some View {
        Text(data)
            .frame(maxWidth: .infinity, maxHeight: .infinity)
    }
}

struct APIView_Previews: PreviewProvider {
    static var previews: some View {
        APIView()
    }
}
