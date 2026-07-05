package com.tuan.shadowenglish.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.tuan.shadowenglish.data.local.entity.LessonProgressEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

@Dao
interface LessonProgressDao {
    @Query("SELECT * FROM lesson_progress WHERE lessonId = :lessonId")
    fun getProgressByLesson(lessonId: Long): Flow<LessonProgressEntity?>

    @Upsert
    suspend fun upsertProgress(progress: LessonProgressEntity)

    @Transaction
    suspend fun incrementPracticeCount(lessonId: Long) {
        val progress = getProgressByLesson(lessonId).first()
        upsertProgress(
            progress?.copy(practiceCount = progress.practiceCount + 1)
                ?: LessonProgressEntity(lessonId = lessonId, practiceCount = 1)
        )
    }

    @Transaction
    suspend fun markCompleted(lessonId: Long) {
        val progress = getProgressByLesson(lessonId).first()
        upsertProgress(
            progress?.copy(isCompleted = true)
                ?: LessonProgressEntity(lessonId = lessonId, isCompleted = true)
        )
    }
}
