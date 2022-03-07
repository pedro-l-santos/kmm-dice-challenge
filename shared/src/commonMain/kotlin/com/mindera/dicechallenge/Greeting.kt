package com.mindera.dicechallenge

class Greeting {
    fun greeting(numFaces: Int): Int {
        return (0 until numFaces).random() + 1;
    }
}