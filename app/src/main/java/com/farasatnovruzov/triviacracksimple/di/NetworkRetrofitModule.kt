package com.farasatnovruzov.triviacracksimple.di

import com.farasatnovruzov.triviacracksimple.data.network.QuestionRetrofitApi
import com.farasatnovruzov.triviacracksimple.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkRetrofitModule {

    @Singleton
    @Provides
    fun provideQuestionRetrofitApi(): QuestionRetrofitApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionRetrofitApi::class.java)
    }

}