package com.example.composewithbottomnavbar.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings

object TopLevelRoutes {
    val routes = listOf(
        TopLevelRoute("Home", Destinations.HomeScreen, Icons.Default.Home),
        TopLevelRoute("Profile", Destinations.ProfileScreen, Icons.Default.Person),
        TopLevelRoute("Settings", Destinations.SettingsScreen, Icons.Default.Settings)
    )
}