package com.farasatnovruzov.triviacracksimple.di

import com.farasatnovruzov.triviacracksimple.data.network.QuestionRetrofitApi
import com.farasatnovruzov.triviacracksimple.data.repository.QuestionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideQuestionRepository(
        api: QuestionRetrofitApi
    ) = QuestionRepository(api)
}