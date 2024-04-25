package com.milkcocoa.info.milkyway.api.atproto.admin

import com.milkcocoa.info.milkyway.atproto.action.AtProtoActions
import com.milkcocoa.info.milkyway.atproto.method.AtProtocolUnitPost
import com.milkcocoa.info.milkyway.domain.Domain
import com.milkcocoa.info.milkyway.models.AtProtocolRequestWithAdmin
import kotlinx.serialization.Serializable

/**
 * Administrative action to update an account's email.
 */
class UpdateAccountEmail(val domain: Domain) :
    AtProtocolUnitPost<UpdateAccountEmail.UpdateAccountEmailRequest>(
        AtProtoActions.AdminUpdateAccountEmail,
        domain,
        UpdateAccountEmailRequest::class
    ) {
    @Serializable
    data class UpdateAccountEmailRequest(
        override val adminPassword: String,
        /**
         * The handle or DID of the repo.
         */
        val account: String,
        val email: String
    ) : AtProtocolRequestWithAdmin
}