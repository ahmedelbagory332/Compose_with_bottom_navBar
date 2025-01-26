package com.example.composewithbottomnavbar.presentation.widget

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composewithbottomnavbar.domain.Destinations
import com.example.composewithbottomnavbar.domain.TopLevelRoutes


@Composable
fun BottomNavBar(
    navController: NavHostController,
    onClick: (destinations: Destinations) -> Unit,
    selectedRoute: Destinations
) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        TopLevelRoutes.routes.forEach { topLevelRoute ->
            val isSelected =
                currentDestination?.route == topLevelRoute.route.toString() || selectedRoute == topLevelRoute.route
            NavigationBarItem(
                icon = {
                    Icon(
                        topLevelRoute.icon,
                        contentDescription = topLevelRoute.name,
                        tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                    )
                },
                label = {
                    Text(
                        text = topLevelRoute.name,
                        color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                    )
                },
                selected = isSelected,
                onClick = {
                    onClick(topLevelRoute.route)
                }
            )
        }
    }
}