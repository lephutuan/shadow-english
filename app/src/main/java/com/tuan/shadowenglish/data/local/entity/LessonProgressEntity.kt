package com.tuan.shadowenglish.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "lesson_progress",
    foreignKeys = [ForeignKey(
        entity = LessonEntity::class,
        parentColumns = ["id"], childColumns = ["lessonId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("lessonId", unique = true)]
)
data class LessonProgressEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val lessonId: Long,
    val isCompleted: Boolean = false,
    val practiceCount: Int = 0,
    val lastPracticedAt: Long? = null,
    val lastSentenceIndex: Int = 0
)
