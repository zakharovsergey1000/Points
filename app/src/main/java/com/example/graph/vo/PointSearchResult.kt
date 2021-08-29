package com.example.graph.vo

import androidx.room.Entity
import androidx.room.TypeConverters
import com.example.graph.db.GithubTypeConverters

@Entity(primaryKeys = ["query"])
@TypeConverters(GithubTypeConverters::class)
data class PointSearchResult(
    val query: String,
    val repoIds: List<Int>,
    val totalCount: Int,
    val next: Int?
)
