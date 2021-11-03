package com.example.taipeizoomcalendar.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taipeizoomcalendar.databinding.ActivityMainBinding
import com.example.taipeizoomcalendar.model.network.ZooCalendar
import dagger.hilt.android.AndroidEntryPoint

/*
    資料庫儲存線上抓下來的資料，顯示在RecyclerView上

    網路
    ZooRepository
    ZooService
    ZooApi
    ZooCalendar

    資料庫
    ZooCalendarDao
    ZooCalendarDatabase

    View
    ZooCalendarAdapter

    上下滑動重整

 */

private const val TAG = "MainActivity"
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()
    private var adapter = ZooCalendarAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewMainZooCalendar.adapter = adapter
        binding.recyclerViewMainZooCalendar.layoutManager = LinearLayoutManager(this)
        
        with(viewModel){
            zooCalendarList.observe(this@MainActivity, ::handleZooCalendar)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshZooCalendar(null, null, 0)
    }

    private fun handleZooCalendar(zooCalendarList: List<ZooCalendar>?){
        if(zooCalendarList == null || zooCalendarList.isEmpty()) return
        if (zooCalendarList.size > adapter.itemCount) {
            adapter.insert(zooCalendarList)
        }else {
            adapter.dataChange(zooCalendarList)
        }
    }
}