package com.example.myapplication.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.screens.CardListScreen
import com.example.myapplication.ui.screens.HomeScreen
import com.example.myapplication.ui.theme.AppTheme

@Composable
fun MainApp() {
    AppTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") {
                HomeScreen(
                    onCategoryClick = { categoryId ->
                        navController.navigate("card_list")
                    },
                    onSwitchScreen = {
                        navController.navigate("card_list")
                    }
                )
            }

            composable("card_list") {
                CardListScreen(
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
