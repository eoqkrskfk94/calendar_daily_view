package com.mobinity.calendardailyview

import java.util.*

data class MyEvent(
    val id: Long,
    val title: String,
    val startTime: Calendar,
    val endTime: Calendar
)

