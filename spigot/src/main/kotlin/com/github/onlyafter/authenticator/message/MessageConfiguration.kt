package com.github.onlyafter.authenticator.message

import org.bukkit.configuration.Configuration

class MessageConfiguration(
    val configuration: Configuration
) {

    fun getMessage(section: String): String {
        val string = configuration.getString("configuration.messages.${section}")
        return string.replace("&", "§")
    }

    fun getWithPlaceholder(section: String, replacers: Map<String, String>): String {
        val message = getMessage(section)

        replacers.forEach {placeholder ->
            run {
                message.replace(placeholder.key, placeholder.value)
            }
        }

        return message
    }

}