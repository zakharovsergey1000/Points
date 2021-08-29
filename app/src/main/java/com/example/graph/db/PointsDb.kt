package com.example.graph.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.graph.vo.Point
import com.example.graph.vo.PointSearchResult

/**
 * Main database description.
 */
@Database(
    entities = [
        Point::class,
        PointSearchResult::class],
    version = 3,
    exportSchema = false
)
abstract class PointsDb : RoomDatabase() {
    abstract fun repoDao(): PointDao
}
