package com.oth.anm.configuration

import android.app.NotificationManager
import android.content.Context


data class NotificationChannelConfig(
        val context: Context,
        val channelId: String,
        val channelName: String,
        val channelDescription: String,
        val channelImportance: ChannelImportance = ChannelImportance.IMPORTANCE_DEFAULT)


enum class ChannelImportance(val value: Int) {
    IMPORTANCE_DEFAULT(NotificationManager.IMPORTANCE_DEFAULT),
    IMPORTANCE_LOW(NotificationManager.IMPORTANCE_LOW),
    IMPORTANCE_MIN(NotificationManager.IMPORTANCE_MIN),
    IMPORTANCE_HIGH(NotificationManager.IMPORTANCE_HIGH),
    IMPORTANCE_MAX(NotificationManager.IMPORTANCE_MAX),
}