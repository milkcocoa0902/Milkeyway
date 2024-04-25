package com.milkcocoa.info.milkyway.models.bsky.record.feed

import com.milkcocoa.info.milkyway.models.atproto.repo.StrongRef
import com.milkcocoa.info.milkyway.models.bsky.record.BskyRecord
import com.milkcocoa.info.milkyway.types.RecordType
import com.milkcocoa.info.milkyway.util.DateTimeSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

/**
 * Record representing a 'repost' of an existing Bluesky post.
 */
@SerialName("app.bsky.feed.repost")
@Serializable
data class RepostRecord(
    val subject: StrongRef,
    /**
     * Client-declared timestamp when this post was originally created.
     */
    @Serializable(with = DateTimeSerializer::class)
    val createdAt: LocalDateTime
) : BskyRecord() {
    override val type: RecordType
        get() = RecordType.RepostRecord
}