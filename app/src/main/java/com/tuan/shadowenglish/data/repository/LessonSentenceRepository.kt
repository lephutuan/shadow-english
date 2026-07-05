package com.tuan.shadowenglish.data.repository

import com.tuan.shadowenglish.data.local.dao.LessonSentenceDao
import com.tuan.shadowenglish.data.local.entity.LessonSentenceEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface LessonSentenceRepository {
    fun getSentencesByLesson(lessonId: Long): Flow<List<LessonSentenceEntity>>
}

class LessonSentenceRepositoryImpl @Inject constructor(
    private val lessonSentenceDao: LessonSentenceDao
) : LessonSentenceRepository {
    override fun getSentencesByLesson(lessonId: Long): Flow<List<LessonSentenceEntity>> =
        lessonSentenceDao.getSentencesByLesson(lessonId)
}
