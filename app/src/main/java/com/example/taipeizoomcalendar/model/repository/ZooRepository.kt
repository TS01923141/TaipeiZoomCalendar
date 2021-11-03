package com.example.taipeizoomcalendar.model.repository

import androidx.lifecycle.LiveData
import com.example.taipeizoomcalendar.model.database.ZooCalendarDatabase
import com.example.taipeizoomcalendar.model.network.ZooCalendar
import com.example.taipeizoomcalendar.model.network.ZooCalendarEntity
import com.example.taipeizoomcalendar.model.network.ZooService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException
import javax.inject.Inject

class ZooRepository @Inject constructor(private val service: ZooService, private val database: ZooCalendarDatabase) {
    val zooCalendarList: LiveData<List<ZooCalendar>> = database.ZooCalendarDao.getZooCalendarList()

    suspend fun refreshZooCalendar(query: String?, limit: Int?, offset: Int?) = withContext(Dispatchers.IO){
        val zooCalendarEntity = getZooCalendarEntity(query, limit, offset)
        if (zooCalendarEntity != null) {
            database.ZooCalendarDao.insertAll(zooCalendarEntity.result.results)
        }
    }

    suspend fun getZooCalendarEntity(query: String?, limit: Int?, offset: Int?) : ZooCalendarEntity? =
        withContext(Dispatchers.IO) {
            try {
                val response = service.getCalendar(query, limit, offset)
                if (response.isSuccessful) {
                    response.body()
                }else {
                    null
                }
            } catch (e: UnknownHostException) {
                //沒網路
                e.printStackTrace()
                null
            }
        }
}