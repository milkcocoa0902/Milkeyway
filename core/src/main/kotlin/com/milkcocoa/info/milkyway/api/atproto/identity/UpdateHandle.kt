package com.milkcocoa.info.milkyway.api.atproto.identity

import com.milkcocoa.info.milkyway.atproto.action.AtProtoActions
import com.milkcocoa.info.milkyway.atproto.method.AtProtocolUnitPost
import com.milkcocoa.info.milkyway.domain.Domain
import com.milkcocoa.info.milkyway.models.AtProtocolRequestWithAdmin
import com.milkcocoa.info.milkyway.models.AtProtocolRequestWithSession
import kotlinx.serialization.Serializable

/**
 * Updates the current account's handle.
 * Verifies handle validity, and updates did:plc document if necessary.
 * Implemented by PDS, and requires auth.
 */
class UpdateHandle(val domain: Domain) :
    AtProtocolUnitPost<UpdateHandle.UpdateHandleRequest>(
        AtProtoActions.UpdateHandle,
        domain,
        UpdateHandleRequest::class
    ) {
    @Serializable
    data class UpdateHandleRequest(
        override val accessJwt: String,
        /**
         * The new handle.
         */
        val handle: String
    ) : AtProtocolRequestWithSession
}