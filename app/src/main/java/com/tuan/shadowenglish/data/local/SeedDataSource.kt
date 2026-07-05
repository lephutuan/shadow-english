package com.tuan.shadowenglish.data.local

import android.content.Context
import com.tuan.shadowenglish.data.local.entity.LessonEntity
import com.tuan.shadowenglish.data.local.entity.LessonSentenceEntity
import com.tuan.shadowenglish.data.local.entity.TopicEntity
import dagger.hilt.android.qualifiers.ApplicationContext
import org.json.JSONObject
import javax.inject.Inject

class SeedDataSource @Inject constructor(
    @param:ApplicationContext private val context: Context
) {
    fun load(): SeedData {
        val json = context.assets.open("shadow_english_seed_data.json")
            .bufferedReader()
            .use { it.readText() }
        val root = JSONObject(json)

        val topics = root.getJSONArray("topics").let { array ->
            List(array.length()) { index ->
                val item = array.getJSONObject(index)
                TopicEntity(
                    id = item.getLong("id"),
                    name = item.getString("name"),
                    nameVi = item.getString("nameVi"),
                    iconRes = item.getString("iconRes"),
                    orderIndex = item.getInt("orderIndex"),
                    colorHex = item.optString("colorHex").takeIf { it.isNotBlank() }
                )
            }
        }

        val lessons = root.getJSONArray("lessons").let { array ->
            List(array.length()) { index ->
                val item = array.getJSONObject(index)
                LessonEntity(
                    id = item.getLong("id"),
                    topicId = item.getLong("topicId"),
                    title = item.getString("title"),
                    titleVi = item.getString("titleVi"),
                    orderIndex = item.getInt("orderIndex"),
                    difficultyLevel = item.getInt("difficultyLevel"),
                    sentenceCount = item.getInt("sentenceCount")
                )
            }
        }

        val sentences = root.getJSONArray("lesson_sentences").let { array ->
            List(array.length()) { index ->
                val item = array.getJSONObject(index)
                LessonSentenceEntity(
                    id = item.getLong("id"),
                    lessonId = item.getLong("lessonId"),
                    orderIndex = item.getInt("orderIndex"),
                    textEn = item.getString("textEn"),
                    textVi = item.getString("textVi")
                )
            }
        }

        return SeedData(topics, lessons, sentences)
    }
}

data class SeedData(
    val topics: List<TopicEntity>,
    val lessons: List<LessonEntity>,
    val sentences: List<LessonSentenceEntity>
)
