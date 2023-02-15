package com.nameisjayant.kmmproject

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    fun getName():String = "Jayant"

    val test = "Hey this is test"
}