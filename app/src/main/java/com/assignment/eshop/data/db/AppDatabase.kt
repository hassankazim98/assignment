package com.assignment.eshop.data.db

import androidx.room.Database
import androidx.room.RoomDatabase


//@Database(entities = arrayOf(TestData::class), version = 1,exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    //abstract fun testDataDao(): TestDataDao

}