package com.mobinity.calendardailyview

import com.alamkanak.weekview.WeekView
import com.alamkanak.weekview.WeekViewEntity

class MyCustomSimpleAdapter : WeekView.SimpleAdapter<MyEvent>() {

    override fun onCreateEntity(item: MyEvent): WeekViewEntity {
        return WeekViewEntity.Event.Builder(item)
            .setId(item.id)
            .setTitle(item.title)
            .setStartTime(item.startTime)
            .setEndTime(item.endTime)
            .build()
    }

}