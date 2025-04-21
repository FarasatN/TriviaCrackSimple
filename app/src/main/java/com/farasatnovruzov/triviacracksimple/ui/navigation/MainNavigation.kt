package com.farasatnovruzov.triviacracksimple.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.farasatnovruzov.triviacracksimple.ui.component.QuestionScreen
import com.farasatnovruzov.triviacracksimple.ui.screen.QuestionCategoryScreen
import com.farasatnovruzov.triviacracksimple.ui.viewmodel.QuestionViewModel

@Composable
fun MainNavigation()
{
    val viewModel: QuestionViewModel = hiltViewModel()
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationScreens.SCREEN_CATEGORY.name,
    ){
        composable(NavigationScreens.SCREEN_CATEGORY.name){
            QuestionCategoryScreen(navController)
        }
        composable("${NavigationScreens.SCREEN_QUESTION.name}/{selectedCategory}",
            arguments = listOf(navArgument("selectedCategory"){type = NavType.StringType})){
            navBackStackEntry ->
            QuestionScreen(
                questionViewModel = viewModel,
                selectedCategory = navBackStackEntry.arguments?.getString("selectedCategory")!!
            )
        }
    }
}