package com.milkcocoa.info.milkyway.api.bsky.feed

import com.milkcocoa.info.milkyway.atproto.method.AtProtocolGet
import com.milkcocoa.info.milkyway.bsky.action.BskyActions
import com.milkcocoa.info.milkyway.domain.Domain
import com.milkcocoa.info.milkyway.models.AtProtocolModel
import com.milkcocoa.info.milkyway.models.AtProtocolRequest
import com.milkcocoa.info.milkyway.models.bsky.feed.GeneratorView
import kotlinx.serialization.Serializable

class GetActorFeeds(val domain: Domain) :
    AtProtocolGet<GetActorFeeds.SearchActorsTypeAheadRequest, GetActorFeeds.GetActorFeedsResponse>(
    action = BskyActions.SearchActorsTypeAhead,
    domain = domain,
    SearchActorsTypeAheadRequest::class,
    GetActorFeedsResponse::class
) {
    @Serializable
    data class SearchActorsTypeAheadRequest(
        val actor: String,
        val limit: Int = 50,
        val cursor: String
    ) : AtProtocolRequest

    @Serializable
    data class GetActorFeedsResponse(
        val cursor: String,
        val feeds: List<GeneratorView>
    ): AtProtocolModel
}