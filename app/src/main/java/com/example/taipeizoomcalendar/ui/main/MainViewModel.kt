package com.example.taipeizoomcalendar.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taipeizoomcalendar.model.repository.ZooRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ZooRepository): ViewModel() {

    val zooCalendarList by lazy { repository.zooCalendarList }

    fun refreshZooCalendar(query:String?, limit:Int?, offset:Int?) = viewModelScope.launch {
        repository.refreshZooCalendar(query, limit, offset)
    }

}