package com.example.composewithbottomnavbar.domain


import kotlinx.serialization.Serializable

sealed class Destinations {
    val route: String get() = this::class.simpleName ?: "unknown"

    @Serializable
    data object HomeScreen : Destinations()

    @Serializable
    data object ProfileScreen : Destinations()

    @Serializable
    data object SettingsScreen : Destinations()

}