package com.example.taipeizoomcalendar.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taipeizoomcalendar.model.network.ZooCalendar

@Database(entities = [ZooCalendar::class], version = 1)
abstract class ZooCalendarDatabase: RoomDatabase() {
    abstract val ZooCalendarDao : ZooCalendarDao
}