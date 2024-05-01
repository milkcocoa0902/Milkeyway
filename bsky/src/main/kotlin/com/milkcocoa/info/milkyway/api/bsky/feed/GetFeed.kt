package com.milkcocoa.info.milkyway.api.bsky.feed

import com.milkcocoa.info.milkyway.atproto.method.AtProtocolGet
import com.milkcocoa.info.milkyway.bsky.action.BskyActions
import com.milkcocoa.info.milkyway.domain.Domain
import com.milkcocoa.info.milkyway.models.AtProtocolGetRequestModel
import com.milkcocoa.info.milkyway.models.AtProtocolModel
import com.milkcocoa.info.milkyway.models.RequireUserSession
import com.milkcocoa.info.milkyway.models.aturi.AtUri
import com.milkcocoa.info.milkyway.models.bsky.feed.defs.FeedViewPost
import kotlinx.serialization.Serializable

class GetFeed(val domain: Domain) :
    AtProtocolGet<GetFeed.GetFeedRequest, GetFeed.GetFeedResponse>(
        action = BskyActions.GetFeed,
        domain = domain,
        GetFeedRequest::class,
        GetFeedResponse::class
    ) {
    @Serializable
    data class GetFeedRequest(
        override val accessJwt: String,
        val feed: AtUri,
        val limit: Int = 50,
        val cursor: String = ""
    ) : RequireUserSession, AtProtocolGetRequestModel

    @Serializable
    data class GetFeedResponse(
        val cursor: String = "",
        val feeds: List<FeedViewPost>
    ) : AtProtocolModel
}