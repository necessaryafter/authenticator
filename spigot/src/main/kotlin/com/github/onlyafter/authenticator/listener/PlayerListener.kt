package com.github.onlyafter.authenticator.listener

import com.github.onlyafter.authenticator.UnauthenticatedCache
import com.github.onlyafter.authenticator.message.MessageConfiguration
import com.github.onlyafter.authenticator.util.isAuthenticable
import com.warrenstrange.googleauth.GoogleAuthenticator
import org.bukkit.configuration.Configuration
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class PlayerListener(
    private val configuration: MessageConfiguration,
    private val unauthenticatedCache: UnauthenticatedCache
) : Listener {

    private val googleAuthenticator: GoogleAuthenticator = GoogleAuthenticator()

    @EventHandler
    private fun handlePlayerConnect(playerJoinEvent: PlayerJoinEvent) {
        val player = playerJoinEvent.player

        if(player.isAuthenticable(configuration)) {
            unauthenticatedCache.addPlayer(player.name)

            val credentials = googleAuthenticator.createCredentials()
            val withPlaceholder = configuration.getWithPlaceholder(
                "authenticate", mapOf(Pair("{key}", credentials.key))
            )

            player.sendMessage(withPlaceholder)
        }
    }

    @EventHandler
    private fun handlePlayerChat(asyncPlayerChatEvent: AsyncPlayerChatEvent) {
        val player = asyncPlayerChatEvent.player

        if(!unauthenticatedCache.isAuthenticated(player.name)) {
            asyncPlayerChatEvent.isCancelled = true
            val message = asyncPlayerChatEvent.message

            // TODO: verify if code is correct
        }
    }


    @EventHandler
    private fun handlePlayerDisconnect(playerQuitEvent: PlayerQuitEvent) {
        unauthenticatedCache.removePlayer(playerQuitEvent.player.name)
    }


}