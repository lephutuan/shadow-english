package com.tuan.shadowenglish.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "lessons",
    foreignKeys = [ForeignKey(
        entity = TopicEntity::class,
        parentColumns = ["id"], childColumns = ["topicId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("topicId")]
)
data class LessonEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val topicId: Long,
    val title: String,
    val titleVi: String,
    val orderIndex: Int,
    val difficultyLevel: Int = 1,
    val sentenceCount: Int = 0
)
