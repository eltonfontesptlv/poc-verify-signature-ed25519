package br.com.petlove.core.domain

data class Credential(
    val publicKey: String,
    val signature: String
)