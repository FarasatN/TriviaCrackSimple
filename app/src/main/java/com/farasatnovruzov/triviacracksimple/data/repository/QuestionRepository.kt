package com.farasatnovruzov.triviacracksimple.data.repository

import com.farasatnovruzov.triviacracksimple.data.model.Question
import com.farasatnovruzov.triviacracksimple.data.network.QuestionRetrofitApi
import com.farasatnovruzov.triviacracksimple.util.Resource
import retrofit2.Response
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val questionRetrofitApi: QuestionRetrofitApi) {

    private suspend fun getQuestion( // Mark as suspend since the lambda will call suspending functions
        getFunc: suspend () -> Response<Question>
    ): Resource<Question?> {
        return try {
            val response = getFunc.invoke() // Invoke the function only once
            if (response.isSuccessful) {
                Resource.Success(data = response.body())
            } else {
                Resource.Error(message = "Network response failed!")
            }
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }

    suspend fun getAllWorldQuestions(): Resource<Question?> = getQuestion { questionRetrofitApi.getAllWorldQuestions() }
    suspend fun getAllAnimalQuestions(): Resource<Question?> = getQuestion { questionRetrofitApi.getAllAnimalQuestions() }
    suspend fun getAllScienceTechnologyQuestions(): Resource<Question?> = getQuestion { questionRetrofitApi.getAllScienceTechnologyQuestions() }
    suspend fun getAllVideoGamesQuestions(): Resource<Question?> = getQuestion { questionRetrofitApi.getAllVideoGamesQuestions() }
    suspend fun getAllMusicQuestions(): Resource<Question?> = getQuestion { questionRetrofitApi.getAllMusicQuestions() }
    suspend fun getAllReligionFaithQuestions(): Resource<Question?> = getQuestion { questionRetrofitApi.getAllReligionFaithQuestions() }
    suspend fun getAllHistoryQuestions(): Resource<Question?> = getQuestion { questionRetrofitApi.getAllHistoryQuestions() }
    suspend fun getAllSportsQuestions(): Resource<Question?> = getQuestion { questionRetrofitApi.getAllSportsQuestions() }
    suspend fun getAllGeographyQuestions(): Resource<Question?> = getQuestion { questionRetrofitApi.getAllGeographyQuestions() }
    suspend fun getAllPeopleQuestions(): Resource<Question?> = getQuestion { questionRetrofitApi.getAllPeopleQuestions() }
}