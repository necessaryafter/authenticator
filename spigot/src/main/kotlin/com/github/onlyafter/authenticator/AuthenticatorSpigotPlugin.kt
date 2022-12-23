package com.github.onlyafter.authenticator

import org.bukkit.plugin.java.JavaPlugin

class AuthenticatorSpigotPlugin : JavaPlugin() {

    companion object {
        lateinit var INSTANCE: AuthenticatorSpigotPlugin
    }

    override fun onLoad() {
        saveDefaultConfig()
    }

    override fun onEnable() {
        INSTANCE = this
    }

}