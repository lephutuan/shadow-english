package com.tuan.shadowenglish.data.repository

import com.tuan.shadowenglish.data.local.dao.TopicDao
import com.tuan.shadowenglish.data.local.entity.TopicEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface TopicRepository {
    fun getAllTopics(): Flow<List<TopicEntity>>
}

class TopicRepositoryImpl @Inject constructor(
    private val topicDao: TopicDao
) : TopicRepository {
    override fun getAllTopics(): Flow<List<TopicEntity>> = topicDao.getAllTopics()
}
