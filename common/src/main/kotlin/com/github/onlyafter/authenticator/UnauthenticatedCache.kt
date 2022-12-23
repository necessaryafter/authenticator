package com.github.onlyafter.authenticator

interface UnauthenticatedCache {

    fun addPlayer(playerName: String)
    fun removePlayer(playerName: String)
    fun isAuthenticated(playerName: String): Boolean

}