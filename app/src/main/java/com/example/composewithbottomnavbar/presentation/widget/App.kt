package com.example.composewithbottomnavbar.presentation.widget

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composewithbottomnavbar.domain.Destinations
import com.example.composewithbottomnavbar.presentation.screens.HomeScreen
import com.example.composewithbottomnavbar.presentation.screens.ProfileScreen
import com.example.composewithbottomnavbar.presentation.screens.SettingsScreen

@Composable
fun App(
    innerPadding: PaddingValues,
    navController: NavHostController,
    onSettingsClick: () -> Unit
) {
    NavHost(
        navController,
        startDestination = Destinations.HomeScreen,
        Modifier.padding(innerPadding)
    ) {
        composable<Destinations.HomeScreen> { HomeScreen(onSettingsClick = onSettingsClick) }
        composable<Destinations.ProfileScreen> { ProfileScreen() }
        composable<Destinations.SettingsScreen> { SettingsScreen() }
    }
}