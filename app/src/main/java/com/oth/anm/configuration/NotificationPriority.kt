package com.oth.anm.configuration

import android.support.v4.app.NotificationCompat

enum class NotificationPriority(val value: Int) {
    PRIORITY_DEFAULT(NotificationCompat.PRIORITY_DEFAULT),
    PRIORITY_LOW(NotificationCompat.PRIORITY_LOW),
    PRIORITY_MIN(NotificationCompat.PRIORITY_MIN),
    PRIORITY_HIGH(NotificationCompat.PRIORITY_HIGH),
    PRIORITY_MAX(NotificationCompat.PRIORITY_MAX),
}