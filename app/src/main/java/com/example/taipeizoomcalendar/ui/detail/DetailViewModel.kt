package com.example.taipeizoomcalendar.ui.detail

import androidx.lifecycle.ViewModel
import com.example.taipeizoomcalendar.model.network.ZooCalendar
import dagger.hilt.android.lifecycle.HiltViewModel

//@HiltViewModel
class DetailViewModel: ViewModel() {
    lateinit var zooCalendar: ZooCalendar
}