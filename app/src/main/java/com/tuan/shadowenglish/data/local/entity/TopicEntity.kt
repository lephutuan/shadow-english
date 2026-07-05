package com.tuan.shadowenglish.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "topics")
data class TopicEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val nameVi: String,
    val iconRes: String,
    val orderIndex: Int,
    val colorHex: String? = null
)
