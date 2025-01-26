package com.example.composewithbottomnavbar.domain


import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    data object HomeScreen : Destinations()

    @Serializable
    data object ProfileScreen : Destinations()

    @Serializable
    data object SettingsScreen : Destinations()

}