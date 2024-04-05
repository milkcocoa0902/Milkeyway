package com.milkcocoa.info.milkyway.models.bsky.actor

import com.milkcocoa.info.milkyway.models.AtProtocolModel
import com.milkcocoa.info.milkyway.models.entity.Label
import com.milkcocoa.info.milkyway.util.DateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

/**
 * get profile
 */

@Serializable
data class ActorProfileViewDetails(
    val did: String,
    val handle: String,
    val displayName: String? = null,
    val description: String? = null,
    val avatar: String? = null,
    val banner: String? = null,
    val followersCount: Int? = null,
    val followsCount: Int? = null,
    val postsCount: Int? = null,
    val associated: Associated? = null,
    @Serializable(with = IndexedAtSerializer::class)
    val indexedAt: LocalDateTime? = null,
    val viewer: Viewer? = null,
    val labels: List<Label> = emptyList()
) : AtProtocolModel {
    companion object {
        object IndexedAtSerializer : DateTimeSerializer("indexedAt")
    }
}