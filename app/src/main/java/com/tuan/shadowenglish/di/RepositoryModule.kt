package com.tuan.shadowenglish.di

import com.tuan.shadowenglish.data.repository.LessonProgressRepository
import com.tuan.shadowenglish.data.repository.LessonProgressRepositoryImpl
import com.tuan.shadowenglish.data.repository.LessonRepository
import com.tuan.shadowenglish.data.repository.LessonRepositoryImpl
import com.tuan.shadowenglish.data.repository.LessonSentenceRepository
import com.tuan.shadowenglish.data.repository.LessonSentenceRepositoryImpl
import com.tuan.shadowenglish.data.repository.TopicRepository
import com.tuan.shadowenglish.data.repository.TopicRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindTopicRepository(impl: TopicRepositoryImpl): TopicRepository

    @Binds
    abstract fun bindLessonRepository(impl: LessonRepositoryImpl): LessonRepository

    @Binds
    abstract fun bindLessonSentenceRepository(
        impl: LessonSentenceRepositoryImpl
    ): LessonSentenceRepository

    @Binds
    abstract fun bindLessonProgressRepository(
        impl: LessonProgressRepositoryImpl
    ): LessonProgressRepository
}
