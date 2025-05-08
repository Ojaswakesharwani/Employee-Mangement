package com.example.employeemanagement

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import com.example.employeemanagement.NavigationModule.DestinationRoute
import com.example.employeemanagement.fragment.DestinationFragment
import com.example.employeemanagement.fragment.GetAllEmpFragment

class MainActivity : AppCompatActivity() {

    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation() {
        try {
            val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.fragment_container) as NavHostFragment


            if (navHostFragment == null) {
                Log.e(TAG, "NavController are not found ")
                return
            }

            navController = navHostFragment.navController
            if (navController == null) {
                Log.e(TAG, "NavController are not found ")
                return
            }


            val graph = createGraph(startDestination = DestinationRoute.StartDestination)
            navController?.graph = graph
            Log.i(TAG, "Navigation graph successfully set")
        } catch (e: Exception) {
            Log.e(TAG, "Navigation setup mein error: ${e.message}", e)
        }
    }

    private fun createGraph(startDestination: DestinationRoute): NavGraph {
        return try {
            navController?.createGraph(startDestination = startDestination.route) {
                fragment<DestinationFragment>(DestinationRoute.StartDestination.route)
                fragment<GetAllEmpFragment>(DestinationRoute.GetAllEmp.route)
            } ?: run {
                Log.e(TAG, "NavController null h")
                throw IllegalStateException("NavController null")
            }
        } catch (e: Exception) {
            Log.e(TAG, "createGraph: creation failed ${e.message}")
            throw e
        }

    }
}