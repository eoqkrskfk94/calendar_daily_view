package com.mobinity.calendardailyview

import android.content.Context
import com.alamkanak.weekview.WeekView
import com.alamkanak.weekview.WeekViewEntity
import com.alamkanak.weekview.jsr310.WeekViewPagingAdapterJsr310
import java.time.LocalDate
import java.time.YearMonth
import java.util.*

class MyCustomPagingAdapter(
    private val loadMoreHandler: (List<YearMonth>) -> Unit
) : WeekViewPagingAdapterJsr310<MyEvent>() {


    override fun onCreateEntity(
        item: MyEvent
    ): WeekViewEntity {
        return WeekViewEntity.Event.Builder(item)
            .setId(item.id)
            .setTitle(item.title)
            .setStartTime(item.startTime)
            .setEndTime(item.endTime)
            .build()
    }

    override fun onEventClick(data: MyEvent) {
        if (data is MyEvent) {
            context.showToast("Clicked ${data.title}")
        }
    }

    override fun onLoadMore(startDate: LocalDate, endDate: LocalDate) {

        loadMoreHandler(yearMonthsBetween(startDate, endDate))
    }
}