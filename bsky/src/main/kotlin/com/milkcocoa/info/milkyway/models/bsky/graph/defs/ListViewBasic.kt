package com.milkcocoa.info.milkyway.models.bsky.graph.defs

import com.milkcocoa.info.milkyway.models.bsky.feed.defs.PostView.Companion.IndexedAtSerializer
import com.milkcocoa.info.milkyway.models.entity.Label
import com.milkcocoa.info.milkyway.util.DateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class ListViewBasic(
    val uri: String,
    val cid: String,
    val name: String,
    val purpose: String,
    val avatar: String = "",
    val labels: List<Label> = emptyList(),
    val viewer: ListViewerState? = null,
    @Serializable(with = IndexedAtSerializer::class)
    val indexedAt: LocalDateTime? = null
){
    companion object {
        object IndexedAtSerializer : DateTimeSerializer("indexedAt")
    }
}