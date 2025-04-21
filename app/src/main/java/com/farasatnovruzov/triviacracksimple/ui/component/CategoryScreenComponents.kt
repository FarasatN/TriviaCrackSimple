package com.farasatnovruzov.triviacracksimple.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Games
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Mosque
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Nature
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Sports
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.farasatnovruzov.triviacracksimple.ui.navigation.NavigationScreens
import com.farasatnovruzov.triviacracksimple.ui.screen.QuestionCategoryScreen
import com.farasatnovruzov.triviacracksimple.ui.viewmodel.QuestionCategories


@Composable
fun CategoryContent(
    navController: NavController,
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
    ) {
        items(QuestionCategories.entries) { category ->
            val allCategories = when (category) {
                QuestionCategories.WORLD -> Pair(QuestionCategories.WORLD, Icons.Default.Public)
                QuestionCategories.ANIMAL -> Pair(QuestionCategories.ANIMAL, Icons.Default.Pets)
                QuestionCategories.SCIENCE_TECHNOLOGY -> Pair(QuestionCategories.SCIENCE_TECHNOLOGY, Icons.Default.Science)
                QuestionCategories.VIDEO_GAMES -> Pair(QuestionCategories.VIDEO_GAMES, Icons.Default.Games)
                QuestionCategories.MUSIC -> Pair(QuestionCategories.MUSIC, Icons.Default.MusicNote)
                QuestionCategories.RELIGION_FAITH -> Pair(QuestionCategories.RELIGION_FAITH, Icons.Default.Mosque)
                QuestionCategories.HISTORY -> Pair(QuestionCategories.HISTORY, Icons.Default.History)
                QuestionCategories.SPORTS -> Pair(QuestionCategories.SPORTS, Icons.Default.Sports)
                QuestionCategories.GEOGRAPHY -> Pair(QuestionCategories.GEOGRAPHY, Icons.Default.Nature)
                QuestionCategories.PEOPLE -> Pair(QuestionCategories.PEOPLE, Icons.Default.People)
            }

            CategoryItem(
                navController = navController,
                category = allCategories
            )
        }
    }
}

@Composable
fun CategoryItem(
    navController: NavController = rememberNavController(),
    category: Pair<QuestionCategories, ImageVector> = Pair(QuestionCategories.WORLD, Icons.Default.Public),
){
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .border(1.dp, Color.Transparent,RoundedCornerShape(24.dp)),
        shape = RoundedCornerShape(24.dp),
        onClick = {
            navController.navigate(route = "${NavigationScreens.SCREEN_QUESTION.name}/${category.first.name}")
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.Transparent),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = category.second,
                contentDescription = category.first.name,
                modifier = Modifier.size(100.dp),
//                tint = Color.Cyan
            )
            Text(
                text = category.first.name,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleMedium,
                fontSize = 17.sp,
//                color = Color.Cyan
            )
        }
    }
}