package com.milkcocoa.info.milkyway.api.atproto.admin

import com.milkcocoa.info.milkyway.atproto.action.AtProtoActions
import com.milkcocoa.info.milkyway.atproto.method.AtProtocolUnitPost
import com.milkcocoa.info.milkyway.domain.Domain
import com.milkcocoa.info.milkyway.models.AtProtocolRequestWithAdmin
import kotlinx.serialization.Serializable

/**
 * Re-enable an account's ability to receive invite codes.
 */
class EnableAccountInvites(val domain: Domain) :
    AtProtocolUnitPost<EnableAccountInvites.EnableAccountInvitesRequest>(
        AtProtoActions.AdminEnableAccountInvites,
        domain,
        EnableAccountInvitesRequest::class
    ) {
    @Serializable
    data class EnableAccountInvitesRequest(
        override val adminPassword: String,
        val account: String,
        /**
         * Optional reason for enabled invites.
         */
        val note: String? = null
    ) : AtProtocolRequestWithAdmin
}