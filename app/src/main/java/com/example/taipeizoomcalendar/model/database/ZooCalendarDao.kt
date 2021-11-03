package com.example.taipeizoomcalendar.model.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.taipeizoomcalendar.model.network.ZooCalendar

@Dao
interface ZooCalendarDao {
    @Query("select * from ZooCalendar")
    fun getZooCalendarList() : LiveData<List<ZooCalendar>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(zooCalendarList: List<ZooCalendar>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(zooCalendarList: ZooCalendar)
}