package com.example.rent_go

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rent_go.Authorization.LogIn
import com.example.rent_go.Authorization.Register
import com.example.rent_go.ProductFiles.ListProduct

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = "main") {
        composable("login") { LogIn(navController) }
        composable("register") { Register(navController) }
        composable("main") { Enter(navController) } // Начальный экран
        composable("home") { ListProduct(navController) }
    }
}
