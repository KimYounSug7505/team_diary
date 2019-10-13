package com.example.team_diary

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.team_diary.Module_Base
import com.example.team_diary.RecyclerViewAdapter

import kotlinx.android.synthetic.main.activity_monthly_calendar.*
import kotlinx.android.synthetic.main.item.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {


    lateinit var scheduleRecyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)

        initView()
    }

    fun initView() {

        scheduleRecyclerViewAdapter = RecyclerViewAdapter(this)

        rv_schedule.layoutManager =  GridLayoutManager(this, Module_Base.DAYS_OF_WEEK)
        rv_schedule.adapter = scheduleRecyclerViewAdapter
        rv_schedule.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
        rv_schedule.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        tv_prev_month.setOnClickListener {
            scheduleRecyclerViewAdapter.changeToPrevMonth()
        }

        tv_next_month.setOnClickListener {
            scheduleRecyclerViewAdapter.changeToNextMonth()
        }

        rv_schedule.setOnClickListener{
            var nextIntent:Intent=Intent(this,input_diary::class.java)
            startActivity(nextIntent)
        }
        tv_weekly_calendar.setOnClickListener{
            var nextIntent:Intent= Intent(this,WeekCalendar::class.java)
        }

    }

    fun refreshCurrentMonth(calendar: Calendar) {
        val sdf = SimpleDateFormat("yyyy MM", Locale.KOREAN)
        tv_current_month.text = sdf.format(calendar.time)
    }
}