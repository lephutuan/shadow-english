package com.tuan.shadowenglish.data.repository

import com.tuan.shadowenglish.data.local.dao.LessonDao
import com.tuan.shadowenglish.data.local.entity.LessonEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface LessonRepository {
    fun getLessonsByTopic(topicId: Long): Flow<List<LessonEntity>>
    fun getLessonById(lessonId: Long): Flow<LessonEntity?>
}

class LessonRepositoryImpl @Inject constructor(
    private val lessonDao: LessonDao
) : LessonRepository {
    override fun getLessonsByTopic(topicId: Long): Flow<List<LessonEntity>> =
        lessonDao.getLessonsByTopic(topicId)

    override fun getLessonById(lessonId: Long): Flow<LessonEntity?> =
        lessonDao.getLessonById(lessonId)
}
