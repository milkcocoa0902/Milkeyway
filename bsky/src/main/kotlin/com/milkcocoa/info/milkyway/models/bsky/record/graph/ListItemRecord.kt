package com.milkcocoa.info.milkyway.models.bsky.record.graph

import com.milkcocoa.info.milkyway.models.bsky.record.BskyRecord
import com.milkcocoa.info.milkyway.types.RecordType
import com.milkcocoa.info.milkyway.util.DateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

/**
 * Record representing an account's inclusion on a specific list. The AppView will ignore duplicate listitem records.
 */
@Serializable
data class ListItemRecord(
    /**
     * The account which is included on the list.
     */
    val subject: String,
    /**
     * Reference (AT-URI) to the list record (app.bsky.graph.list).
     */
    val list: String,
    @Serializable(with = CreatedAtSerializer::class)
    val createdAt: LocalDateTime,
) : BskyRecord() {
    override val type: RecordType
        get() = RecordType.ListItemRecord

    companion object {
        object CreatedAtSerializer : DateTimeSerializer("createdAt")
    }
}