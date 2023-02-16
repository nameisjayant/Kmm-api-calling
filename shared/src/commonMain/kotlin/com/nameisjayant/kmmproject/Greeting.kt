package com.nameisjayant.kmmproject

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    val test = "Hey this is test"
    val name = "M"
}