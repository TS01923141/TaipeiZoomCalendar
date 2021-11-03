package com.example.taipeizoomcalendar.model.network

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
data class ZooCalendarEntity(
    val result: Result
) {
    companion object{
        val entity = ZooCalendarEntity(
            Result.empty
        )
    }
}

@JsonClass(generateAdapter = true)
data class Result(
    val limit: Int,
    val offset: Int,
    val count: Int,
    val sort: String,
    val results: List<ZooCalendar>
) {
    companion object{
        val empty = Result(
            -1,
            0,
            0,
            "",
            arrayListOf()
        )
    }
}

@Entity
@Parcelize
@JsonClass(generateAdapter = true)
data class ZooCalendar(
    val D_Title: String,
    val D_Site: String,
    val D_Pic_URL: String,
    val D_RemoveDate: String,
    val D_Summary: String,
    val D_Address: String,
    val D_EndDate: String,
    val D_Geo: String,
    val D_Location: String,
    val D_Brief: String,
    val D_Pic_Alt: String,
    val D_AddDate: String,
    val D_Time: String,
    @Json(name = "﻿D_Category") val D_Category: String,
    val D_Keywords: String,
    val D_site_URL: String,
    @PrimaryKey val _id: String,
    val D_StartDate: String
) : Parcelable {
    companion object {
        val entity = ZooCalendar(
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
        )
    }
}

/*
    {
    "result": {
        "limit": 1,
        "offset": 0,
        "count": 6,
        "sort": "",
        "results": [
            {
                "D_Title": "【象足跡、象前進】特展",
                "D_Site": "臺北市立動物園",
                "D_Pic_URL": "",
                "D_RemoveDate": "2026/1/1",
                "D_Summary": "",
                "D_Address": "臺北市文山區新光路二段30號",
                "D_EndDate": "2025/12/31",
                "D_Geo": "MULTIPOINT ((121.5822768 24.9976682))",
                "D_Location": "臺北市立動物園 教育中心 地下一樓特展區",
                "D_Brief": "大象「林旺」與「馬蘭」在臺北市立動物園將近五十年的歲月，是伴隨許多人成長的回憶。然而因為棲息地喪失與象牙盜獵，亞洲象現正面臨族群「瀕危」窘境，本次特展除了從「象足跡」回顧大象林旺與馬蘭在臺灣的生命歷程，亦從「象前進」喚醒對保育野生象保育的關注，注意全球一起攜手為保育野生動物行動盡份己力。邀請大家跟著大象前進，了解大象保育如何與我們的生活息息相關，共同為延續人與大象的生命旅程而努力！",
                "D_Pic_Alt": "",
                "D_AddDate": "2019/6/28",
                "D_Time": "09:00-17:00",
                "﻿D_Category": "展覽",
                "D_Keywords": "【象足跡、象前進】特展",
                "D_site_URL": "https://www.zoo.gov.taipei/News_Content.aspx?n=FF99E6A67512AD9B＆sms=9D72E82EC16F3E64＆s=8001DB11D775A5EF＆ccms_cs=1",
                "_id": 1,
                "D_StartDate": "2019/6/29"
            }
        ]
    }
}
 */