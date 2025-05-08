package com.example.employeemanagement.Restrofit

sealed class DestinationRoute(val route: String) {

    data object GetAllEmp : DestinationRoute("getAllEmp")
    data object StartDestination : DestinationRoute("startDestination")

    companion object {
        fun fromRoute(route: String?): DestinationRoute {
            return when (route) {
                GetAllEmp.route -> GetAllEmp
                StartDestination.route -> StartDestination
                else -> throw IllegalArgumentException("Route $route is not recognized")
            }

        }
    }
}