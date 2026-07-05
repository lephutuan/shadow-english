package com.tuan.shadowenglish.di

import android.content.Context
import androidx.room.Room
import com.tuan.shadowenglish.data.local.dao.LessonDao
import com.tuan.shadowenglish.data.local.dao.LessonProgressDao
import com.tuan.shadowenglish.data.local.dao.LessonSentenceDao
import com.tuan.shadowenglish.data.local.dao.TopicDao
import com.tuan.shadowenglish.data.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "shadow_english.db").build()

    @Provides
    fun provideTopicDao(database: AppDatabase): TopicDao = database.topicDao()

    @Provides
    fun provideLessonDao(database: AppDatabase): LessonDao = database.lessonDao()

    @Provides
    fun provideLessonSentenceDao(database: AppDatabase): LessonSentenceDao =
        database.lessonSentenceDao()

    @Provides
    fun provideLessonProgressDao(database: AppDatabase): LessonProgressDao =
        database.lessonProgressDao()
}
