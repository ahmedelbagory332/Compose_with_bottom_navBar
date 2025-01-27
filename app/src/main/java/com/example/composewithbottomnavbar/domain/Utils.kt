package com.example.composewithbottomnavbar.domain

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

fun navigateToRoute(navController: NavController, route: Destinations) {
    navController.navigate(route) {
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}