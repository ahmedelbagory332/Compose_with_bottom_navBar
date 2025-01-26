package com.example.composewithbottomnavbar.presentation

import androidx.lifecycle.ViewModel
import com.example.composewithbottomnavbar.domain.Destinations
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    private val _stateRoute = MutableStateFlow(MainState())
    val routeState: StateFlow<MainState>
        get() = _stateRoute

    fun onRouteSelected(route: Destinations) {
        _stateRoute.value = MainState(route)
    }
}