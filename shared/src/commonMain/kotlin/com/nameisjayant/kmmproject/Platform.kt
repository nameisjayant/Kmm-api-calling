package com.nameisjayant.kmmproject

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform