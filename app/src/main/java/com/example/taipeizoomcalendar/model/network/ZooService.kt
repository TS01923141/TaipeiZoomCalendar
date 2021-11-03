package com.example.taipeizoomcalendar.model.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ZooService {
    /**
     * q -> 關鍵字
     * limit -> 限制筆數
     * offset -> 從第幾筆開始(位移筆數)
     */
    @GET("87b38c72-f9e7-4f75-b3af-5b6684f2a059?scope=resourceAquire")
    suspend fun getCalendar(
        @Query("q") query: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Response<ZooCalendarEntity>
}