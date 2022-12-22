package br.com.petlove.core.domain

data class Message(
    val method: String,
    val path: String,
    val timestamp: String,
    val payload: String
)

fun Message.build() = method.plus(path).plus(timestamp).plus(payload)
