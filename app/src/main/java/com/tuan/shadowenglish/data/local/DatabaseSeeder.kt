package com.tuan.shadowenglish.data.local

import com.tuan.shadowenglish.data.local.dao.LessonDao
import com.tuan.shadowenglish.data.local.dao.LessonSentenceDao
import com.tuan.shadowenglish.data.local.dao.TopicDao
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class DatabaseSeeder @Inject constructor(
    private val seedDataSource: SeedDataSource,
    private val topicDao: TopicDao,
    private val lessonDao: LessonDao,
    private val lessonSentenceDao: LessonSentenceDao
) {
    suspend fun seedIfEmpty() {
        if (topicDao.getAllTopics().first().isNotEmpty()) return

        val seedData = seedDataSource.load()
        topicDao.insertAll(seedData.topics)
        lessonDao.insertAll(seedData.lessons)
        lessonSentenceDao.insertAll(seedData.sentences)
    }
}
