package com.oth.anm.configuration

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import com.oth.anm.BuildConfig
import java.util.*


class NotificationHandler(private val notificationConfig: NotificationConfig) {

    companion object {
        val LIBRARY_VERSION = BuildConfig.VERSION_NAME

        private fun getnotificationManager(context: Context) = NotificationManagerCompat.from(context)

        fun clearNotification(context: Context, notificationId: Int) {
            getnotificationManager(context).cancel(notificationId)
        }

        fun clearNotifications(context: Context) {
            getnotificationManager(context).cancelAll()
        }
    }

    /**
     * Shows the notification on the phone.
     * Returns: NotificationId
     */
    fun show(): Int {

        // create notification channel
        createNotificationChannel(notificationConfig.notificationChannelConfig)

        // build notification
        val mBuilder = NotificationCompat.Builder(notificationConfig.context, notificationConfig.notificationChannelConfig.channelId).apply {
            // basic
            setLargeIcon(BitmapFactory.decodeResource(notificationConfig.notificationChannelConfig.context.resources, notificationConfig.smallIcon))
            setBadgeIconType(notificationConfig.smallIcon)
            setSmallIcon(notificationConfig.smallIcon)
            setContentTitle(notificationConfig.title)
            setContentText(notificationConfig.text)
            setPriority(notificationConfig.notificationPriority.value)
            setAutoCancel(notificationConfig.autoCancel)

            when (notificationConfig.notificationStyle) {
                NotificationStyle.BIG_TEXT -> {
                    setStyle(NotificationCompat.BigTextStyle().bigText(notificationConfig.bigText))
                }

                else -> {

                }
            }

            // pending intent
            val pendingIntent = PendingIntent.getActivity(notificationConfig.context, 0, notificationConfig.intent, PendingIntent.FLAG_UPDATE_CURRENT)
            setContentIntent(pendingIntent)
        }


        val random = Random().nextInt(9999)
        getnotificationManager(notificationConfig.context).notify(random, mBuilder.build())

        return random
    }


    private fun createNotificationChannel(notificationChannelConfig: NotificationChannelConfig) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(notificationChannelConfig.channelId, notificationChannelConfig.channelName, notificationChannelConfig.channelImportance.value)
            channel.description = notificationChannelConfig.channelDescription

            val notificationManager = notificationChannelConfig.context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

}