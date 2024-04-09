package com.milkcocoa.info.milkyway.models.bsky.actor

import com.milkcocoa.info.milkyway.models.bsky.graph.defs.ListViewBasic
import kotlinx.serialization.Serializable

@Serializable
data class ViewerState(
    val muted: Boolean? = null,
    val mutedByList: List<ListViewBasic> = emptyList(),
    val blockedBy: Boolean? = null,
    val blocking: String? = null,
    val blockingByList: List<ListViewBasic> = emptyList(),
    val following: String? = null,
    val followedBy: String? = null
)