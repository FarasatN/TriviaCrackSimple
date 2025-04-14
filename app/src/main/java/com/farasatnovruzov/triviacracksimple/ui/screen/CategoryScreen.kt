package com.farasatnovruzov.triviacracksimple.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.farasatnovruzov.triviacracksimple.ui.component.CategoryContent
import com.farasatnovruzov.triviacracksimple.ui.viewmodel.QuestionCategories


@Composable
fun QuestionCategoryScreen(
    navController: NavController,
    modifier: Modifier = Modifier
){
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CategoryContent(
                navController
            )
        }

    }

}