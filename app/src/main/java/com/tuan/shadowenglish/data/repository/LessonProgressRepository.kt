package com.tuan.shadowenglish.data.repository

import com.tuan.shadowenglish.data.local.dao.LessonProgressDao
import com.tuan.shadowenglish.data.local.entity.LessonProgressEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface LessonProgressRepository {
    fun getProgressByLesson(lessonId: Long): Flow<LessonProgressEntity?>
    suspend fun incrementPracticeCount(lessonId: Long)
    suspend fun markCompleted(lessonId: Long)
}

class LessonProgressRepositoryImpl @Inject constructor(
    private val lessonProgressDao: LessonProgressDao
) : LessonProgressRepository {
    override fun getProgressByLesson(lessonId: Long): Flow<LessonProgressEntity?> =
        lessonProgressDao.getProgressByLesson(lessonId)

    override suspend fun incrementPracticeCount(lessonId: Long) {
        lessonProgressDao.incrementPracticeCount(lessonId)
    }

    override suspend fun markCompleted(lessonId: Long) {
        lessonProgressDao.markCompleted(lessonId)
    }
}
