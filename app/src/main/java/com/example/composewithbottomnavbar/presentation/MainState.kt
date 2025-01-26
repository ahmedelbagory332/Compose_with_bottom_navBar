package com.example.composewithbottomnavbar.presentation

import com.example.composewithbottomnavbar.domain.Destinations
import com.example.composewithbottomnavbar.domain.TopLevelRoutes

data class MainState(
    val route: Destinations =  TopLevelRoutes.routes.first().route,
)