package com.example.taipeizoomcalendar.ui.main

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.RecyclerView
import com.example.taipeizoomcalendar.R
import com.example.taipeizoomcalendar.databinding.ItemZooCalendarBinding
import com.example.taipeizoomcalendar.model.network.ZooCalendar
import com.example.taipeizoomcalendar.ui.detail.DetailActivity

private const val TAG = "ZooCalendarAdapter"
class ZooCalendarAdapter: RecyclerView.Adapter<ZooCalendarAdapter.ViewHolder>() {
    private lateinit var context: Context
    private val zooCalendarList: MutableList<ZooCalendar> = arrayListOf()

//    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        val textView_zooCalendar_title : TextView = itemView.findViewById(R.id.textView_zooCalendar_title)
//        val textView_zooCalendar_brief: TextView = itemView.findViewById(R.id.textView_zooCalendar_brief)
//        val textView_zooCalendar_exhibitionTime: TextView = itemView.findViewById(R.id.textView_zooCalendar_exhibitionTime)
//        val constraintLayout_zooCalendar_frame: ConstraintLayout = itemView.findViewById(R.id.constraintLayout_zooCalendar_frame)
//    }

    inner class ViewHolder(binding: ItemZooCalendarBinding): RecyclerView.ViewHolder(binding.root){
        val binding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
//        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_zoo_calendar, parent, false))
        return ViewHolder(ItemZooCalendarBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textViewZooCalendarTitle.text = zooCalendarList[position].D_Title
        holder.binding.textViewZooCalendarBrief.text = zooCalendarList[position].D_Brief
        holder.binding.textViewZooCalendarExhibitionTime.text = "${zooCalendarList[position].D_StartDate} ~ ${zooCalendarList[position].D_EndDate}"
        holder.binding.constraintLayoutZooCalendarFrame.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("zoo_calendar", zooCalendarList[position])
            context.startActivity(intent)
        }
//        holder.textView_zooCalendar_title.text = zooCalendarList[position].D_Title
//        holder.textView_zooCalendar_brief.text = zooCalendarList[position].D_Brief
//        holder.textView_zooCalendar_exhibitionTime.text = "${zooCalendarList[position].D_StartDate} ~ ${zooCalendarList[position].D_EndDate}"
//        holder.constraintLayout_zooCalendar_frame.setOnClickListener {
//            val intent = Intent(context, DetailActivity::class.java)
//            intent.putExtra("zoo_calendar", zooCalendarList[position])
//            context.startActivity(intent)
//        }

    }

    override fun getItemCount(): Int {
        return zooCalendarList.size
    }

    fun insert(zooCalendarList: List<ZooCalendar>){
        val start = itemCount
        this.zooCalendarList.apply {
            clear()
            addAll(zooCalendarList)
        }
        notifyItemRangeInserted(start, zooCalendarList.size)
    }

    fun dataChange(zooCalendarList: List<ZooCalendar>) {
        if (this.zooCalendarList == zooCalendarList) return
        this.zooCalendarList.apply {
            clear()
            addAll(zooCalendarList)
        }
        notifyDataSetChanged()
    }
}