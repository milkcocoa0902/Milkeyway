package com.milkcocoa.info.milkyway.models.did

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class DidDoc(
    @SerialName("@context")
    val context: List<String>,
    val id: String,
    val alsoKnownAs: List<String>,
    val verificationMethod: List<VerificationMethod>,
    val service: List<Service>
)