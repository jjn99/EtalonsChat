package com.cours.etalonschat.models

data class Message(
    val sender: String,
    val receiver: String,
    val text: String,
    val timestamp: Long ,
    val isReceived: Boolean = true
)
