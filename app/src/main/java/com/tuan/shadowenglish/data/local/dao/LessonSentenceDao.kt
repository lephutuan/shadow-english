package com.tuan.shadowenglish.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tuan.shadowenglish.data.local.entity.LessonSentenceEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LessonSentenceDao {
    @Query("SELECT * FROM lesson_sentences WHERE lessonId = :lessonId ORDER BY orderIndex")
    fun getSentencesByLesson(lessonId: Long): Flow<List<LessonSentenceEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(sentences: List<LessonSentenceEntity>)
}
