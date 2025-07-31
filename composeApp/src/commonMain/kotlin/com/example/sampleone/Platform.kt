package com.example.sampleone

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform