package com.tuan.shadowenglish.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tuan.shadowenglish.data.local.dao.LessonDao
import com.tuan.shadowenglish.data.local.dao.LessonProgressDao
import com.tuan.shadowenglish.data.local.dao.LessonSentenceDao
import com.tuan.shadowenglish.data.local.dao.TopicDao
import com.tuan.shadowenglish.data.local.entity.LessonEntity
import com.tuan.shadowenglish.data.local.entity.LessonProgressEntity
import com.tuan.shadowenglish.data.local.entity.LessonSentenceEntity
import com.tuan.shadowenglish.data.local.entity.TopicEntity

@Database(
    entities = [
        TopicEntity::class,
        LessonEntity::class,
        LessonSentenceEntity::class,
        LessonProgressEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun topicDao(): TopicDao
    abstract fun lessonDao(): LessonDao
    abstract fun lessonSentenceDao(): LessonSentenceDao
    abstract fun lessonProgressDao(): LessonProgressDao
}
