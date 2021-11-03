package com.example.taipeizoomcalendar.model.repository

import com.example.taipeizoomcalendar.model.database.ZooCalendarDatabase
import com.example.taipeizoomcalendar.model.network.ZooCalendar
import com.example.taipeizoomcalendar.model.network.ZooCalendarEntity
import com.example.taipeizoomcalendar.model.network.ZooService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.net.UnknownHostException

class ZooRepositoryTest{

    private lateinit var zooRepository: ZooRepository

    @MockK private lateinit var service: ZooService
    @MockK private lateinit var database: ZooCalendarDatabase
    @MockK private lateinit var zooCalendarList: List<ZooCalendar>

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        zooRepository = ZooRepository(service, database)
    }

    @Test
    fun `should return null when throws UnknownHostException`() {
        coEvery { service.getCalendar(null, null, null) } throws UnknownHostException()
        runBlocking {
            val zooCalendarEntity = zooRepository.getZooCalendarEntity(null,null,null)
            Assert.assertEquals(zooCalendarEntity, null)
        }
    }

    @Test
    fun `should return null when response not successful`() {
        coEvery { service.getCalendar(null, null, null).isSuccessful } returns false
        runBlocking {
            val zooCalendarEntity = zooRepository.getZooCalendarEntity(null, null, null)
            Assert.assertEquals(zooCalendarEntity, null)
        }
    }

    @Test
    fun `should return ZooCalendarEntity from service`() {
        coEvery { service.getCalendar(null, null, null).isSuccessful } returns true
        coEvery { service.getCalendar(null, null, null).body() } returns ZooCalendarEntity.entity
        runBlocking {
            val zooCalendarEntity = zooRepository.getZooCalendarEntity(null, null, null)
            Assert.assertEquals(zooCalendarEntity, ZooCalendarEntity.entity)
        }
    }
}