package com.github.onlyafter.authenticator.util

import com.github.onlyafter.authenticator.message.MessageConfiguration
import org.bukkit.entity.Player

fun Player.isAuthenticable(messageConfiguration: MessageConfiguration): Boolean {
    return hasPermission(messageConfiguration.getMessage("configuration.permission"))
}
