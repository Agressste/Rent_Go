package com.example.rent_go

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rent_go.Authorization.LogIn
import com.example.rent_go.Authorization.Register
import com.example.rent_go.ProductFiles.ListProduct
import com.example.rent_go.ProductFiles.TovarAdd

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = "dobavit") {
        composable("login") { LogIn(navController) }
        composable("register") { Register(navController) }
        composable("main") { Enter(navController) } // Начальный экран

        composable("home") { ListProduct(navController) } // Главный экран
        composable("dobavit") { TovarAdd(navController, context = LocalContext.current) } // Добавление товара
    }
}
