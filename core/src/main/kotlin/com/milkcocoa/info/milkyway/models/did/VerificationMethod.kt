package com.milkcocoa.info.milkyway.models.did

import kotlinx.serialization.Serializable

@Serializable
data class VerificationMethod(
    val id: String,
    val type: String,
    val controller: String,
    val publicKeyMultibase: String
)