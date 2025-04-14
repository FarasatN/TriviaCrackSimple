package com.farasatnovruzov.triviacracksimple.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farasatnovruzov.triviacracksimple.data.model.Question
import com.farasatnovruzov.triviacracksimple.data.repository.QuestionRepository
import com.farasatnovruzov.triviacracksimple.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuestionViewModel @Inject constructor(
    private val questionRepository: QuestionRepository
) : ViewModel() {

    val questionState = mutableStateOf<Resource<Question?>>(Resource.Loading())
    suspend fun getAllQuestions(selectedCategory: String) {
        questionState.value = Resource.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            questionState.value = when (selectedCategory) {
                QuestionCategories.WORLD.name -> questionRepository.getAllWorldQuestions()
                QuestionCategories.ANIMAL.name -> questionRepository.getAllAnimalQuestions()
                QuestionCategories.SCIENCE_TECHNOLOGY.name -> questionRepository.getAllScienceTechnologyQuestions()
                QuestionCategories.VIDEO_GAMES.name -> questionRepository.getAllVideoGamesQuestions()
                QuestionCategories.MUSIC.name -> questionRepository.getAllMusicQuestions()

                QuestionCategories.RELIGION_FAITH.name -> questionRepository.getAllReligionFaithQuestions()
                QuestionCategories.HISTORY.name -> questionRepository.getAllHistoryQuestions()
                QuestionCategories.SPORTS.name -> questionRepository.getAllSportsQuestions()
                QuestionCategories.GEOGRAPHY.name -> questionRepository.getAllGeographyQuestions()
                else -> {
                    questionRepository.getAllPeopleQuestions()
                }
            }
        }
    }

    fun getTotalQuestionsCount(): Int{
        return questionState.value.data?.size ?: 0

    }
}