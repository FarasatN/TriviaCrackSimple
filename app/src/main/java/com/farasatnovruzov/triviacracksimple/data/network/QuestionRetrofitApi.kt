package com.farasatnovruzov.triviacracksimple.data.network

import com.farasatnovruzov.triviacracksimple.data.model.Question
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Singleton


@Singleton
interface QuestionRetrofitApi {

    @GET("world.json")
    suspend fun getAllWorldQuestions(): Response<Question>

    @GET("animals.json")
    suspend fun getAllAnimalQuestions(): Response<Question>

    @GET("science-technology.json")
    suspend fun getAllScienceTechnologyQuestions(): Response<Question>

    @GET("video-games.json")
    suspend fun getAllVideoGamesQuestions(): Response<Question>

    @GET("music.json")
    suspend fun getAllMusicQuestions(): Response<Question>

    @GET("religion-faith.json")
    suspend fun getAllReligionFaithQuestions(): Response<Question>

    @GET("history.json")
    suspend fun getAllHistoryQuestions(): Response<Question>

    @GET("sports.json")
    suspend fun getAllSportsQuestions(): Response<Question>

    @GET("geography.json")
    suspend fun getAllGeographyQuestions(): Response<Question>

    @GET("people.json")
    suspend fun getAllPeopleQuestions(): Response<Question>



}