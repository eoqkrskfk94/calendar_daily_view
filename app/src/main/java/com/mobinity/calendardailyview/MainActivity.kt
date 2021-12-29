package com.mobinity.calendardailyview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alamkanak.weekview.WeekView
import com.alamkanak.weekview.WeekViewEntity
import java.text.SimpleDateFormat
import java.time.YearMonth
import java.util.*

class MainActivity : AppCompatActivity() {

    private val adapter: MyCustomPagingAdapter by lazy {
        MyCustomPagingAdapter(
            loadMoreHandler = this::onLoadMore,
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val cal = Calendar.getInstance()
        val cal2 = Calendar.getInstance()
        val cal3 = Calendar.getInstance()
        val cal4 = Calendar.getInstance()
        val sdf = SimpleDateFormat("yyyy MM dd HH:mm:ss", Locale.ENGLISH)
        cal.time = sdf.parse("2021 12 29 16:02:37") // all done
        cal2.time = sdf.parse("2021 12 29 17:32:37") // all done

        cal3.time = sdf.parse("2021 12 29 17:32:37") // all done
        cal4.time = sdf.parse("2021 12 29 17:52:37") // all done


        val events = listOf(MyEvent(1,"hi", cal, cal2), MyEvent(2,"hiasdfasdf", cal3, cal4))

        //val adapter = MyCustomSimpleAdapter()
        findViewById<WeekView>(R.id.weekView).adapter = adapter

        adapter.submitList(events)
    }

    private fun onLoadMore(yearMonths: List<YearMonth>) {
    }
}