package com.example.composewithbottomnavbar.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composewithbottomnavbar.domain.TopLevelRoutes
import com.example.composewithbottomnavbar.presentation.theme.ComposeWithBottomNavBarTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ComposeWithBottomNavBarTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination
                            var selectedRoute by remember { mutableStateOf(TopLevelRoutes.routes.first().route) }
                            TopLevelRoutes.routes.forEach { topLevelRoute ->
                                val isSelected = currentDestination?.route == topLevelRoute.route.toString() || selectedRoute == topLevelRoute.route

                                NavigationBarItem(
                                    icon = {
                                        Icon(
                                            topLevelRoute.icon,
                                            contentDescription = topLevelRoute.name,
                                            tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                                        )
                                    },
                                    label = { Text(
                                        text = topLevelRoute.name,
                                        color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                                    ) },
                                    selected = isSelected,
                                    onClick = {
                                        selectedRoute = topLevelRoute.route
                                        navController.navigate(topLevelRoute.route) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }
                                )
                            }
                        }
                    }) { innerPadding ->
                    App(innerPadding, navController)
                }
            }
        }
    }
}
