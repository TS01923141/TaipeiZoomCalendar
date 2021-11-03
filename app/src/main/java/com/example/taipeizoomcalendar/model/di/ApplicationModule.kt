package com.example.taipeizoomcalendar.model.di

import android.content.Context
import androidx.room.Room
import com.example.taipeizoomcalendar.model.database.ZooCalendarDatabase
import com.example.taipeizoomcalendar.model.network.ZooService
import com.example.taipeizoomcalendar.model.repository.ZooRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.annotation.Signed
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://data.taipei/api/v1/dataset/")
        .client(createClient())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private fun createClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectionPool(ConnectionPool(0, 5, TimeUnit.MINUTES))
            .protocols(listOf(Protocol.HTTP_1_1))
        return okHttpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideZooApi(): ZooService = provideRetrofit().create(ZooService::class.java)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ZooCalendarDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            ZooCalendarDatabase::class.java,
            "zooCalendar").build()
}