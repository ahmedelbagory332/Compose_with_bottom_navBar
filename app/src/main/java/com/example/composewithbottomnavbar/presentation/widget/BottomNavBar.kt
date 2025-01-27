package com.example.composewithbottomnavbar.presentation.widget

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.composewithbottomnavbar.domain.Destinations
import com.example.composewithbottomnavbar.domain.TopLevelRoutes


@Composable
fun BottomNavBar(
    onClick: (destinations: Destinations) -> Unit,
    currentRoute: String
) {
    NavigationBar {
        TopLevelRoutes.routes.forEach { topLevelRoute ->
            val isSelected =
                currentRoute == topLevelRoute.route.route
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
                alwaysShowLabel = isSelected,
                onClick = {
                    onClick(topLevelRoute.route)
                }
            )
        }
    }
}