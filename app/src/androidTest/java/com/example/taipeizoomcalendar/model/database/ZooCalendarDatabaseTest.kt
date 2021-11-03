package com.example.taipeizoomcalendar.model.database

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.example.taipeizoomcalendar.model.network.ZooCalendar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.After
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.IOException

class ZooCalendarDatabaseTest {
    private lateinit var dao : ZooCalendarDao
    private lateinit var db: ZooCalendarDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, ZooCalendarDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        dao = db.ZooCalendarDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndQueryLiveData() {
        GlobalScope.launch {
            val zooCalendar = ZooCalendar.entity
            dao.getZooCalendarList().observeForever {
                Assert.assertEquals(it.size, 1)
            }
            dao.insert(zooCalendar)
        }
    }
}