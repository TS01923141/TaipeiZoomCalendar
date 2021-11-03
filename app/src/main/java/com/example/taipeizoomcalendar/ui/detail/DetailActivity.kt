package com.example.taipeizoomcalendar.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.ViewCompat
import com.example.taipeizoomcalendar.R
import com.example.taipeizoomcalendar.databinding.ActivityDetailBinding
import com.example.taipeizoomcalendar.model.network.ZooCalendar
import com.example.taipeizoomcalendar.model.utils.AnimationUtils
import dagger.hilt.android.AndroidEntryPoint

/*
    顯示item的詳細內容
    用到動畫跳轉功能
 */

private const val TAG = "DetailActivity"
@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    private val viewModel : DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val type = intent.getStringExtra("type")
//        if (type != null) {
//            AnimationUtils.init(this, type)
//        }

        viewModel.zooCalendar = intent.getParcelableExtra("zoo_calendar")?: ZooCalendar.entity

        binding.includeDetailTitleBar.imageViewTitleBarBack.setOnClickListener { onBackPressed() }
        binding.includeDetailTitleBar.textViewTitleBarTitle.text = viewModel.zooCalendar.D_Title
        binding.textViewDetailBrief.text = viewModel.zooCalendar.D_Brief
    }
}