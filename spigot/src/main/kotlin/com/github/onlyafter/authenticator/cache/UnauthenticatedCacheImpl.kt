package com.github.onlyafter.authenticator.cache

import com.github.onlyafter.authenticator.UnauthenticatedCache

class UnauthenticatedCacheImpl : UnauthenticatedCache {

    private val cache = mutableListOf<String>()
    override fun addPlayer(playerName: String) {
        cache.add(playerName)
    }

    override fun removePlayer(playerName: String) {
        cache.remove(playerName)
    }

    override fun isAuthenticated(playerName: String): Boolean {
        return !cache.contains(playerName)
    }

}