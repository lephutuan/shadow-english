package com.tuan.shadowenglish.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "lesson_sentences",
    foreignKeys = [ForeignKey(
        entity = LessonEntity::class,
        parentColumns = ["id"], childColumns = ["lessonId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("lessonId")]
)
data class LessonSentenceEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val lessonId: Long,
    val orderIndex: Int,
    val textEn: String,
    val textVi: String
)
