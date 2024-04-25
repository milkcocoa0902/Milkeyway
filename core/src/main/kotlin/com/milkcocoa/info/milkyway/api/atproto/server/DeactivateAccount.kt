package com.milkcocoa.info.milkyway.api.atproto.server

import com.milkcocoa.info.milkyway.atproto.action.AtProtoActions
import com.milkcocoa.info.milkyway.atproto.method.AtProtocolUnitPost
import com.milkcocoa.info.milkyway.domain.Domain
import com.milkcocoa.info.milkyway.models.AtProtocolRequestWithSession
import com.milkcocoa.info.milkyway.util.DateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

/**
 * Deactivates a currently active account.
 * Stops serving of repo, and future writes to repo until reactivated.
 * Used to finalize account migration with the old host after the account has been activated on the new host.
 */
class DeactivateAccount(val domain: Domain) :
    AtProtocolUnitPost<DeactivateAccount.DeactivateAccountRequest>(
        AtProtoActions.DeactivateAccount,
        domain,
        DeactivateAccountRequest::class
    ) {
    @Serializable
    data class DeactivateAccountRequest(
        override val accessJwt: String,
        @Serializable(with = DateTimeSerializer::class)
        val deleteAfter: LocalDateTime
    ) : AtProtocolRequestWithSession
}