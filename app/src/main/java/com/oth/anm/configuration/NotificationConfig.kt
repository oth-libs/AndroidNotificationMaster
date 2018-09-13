package com.oth.anm.configuration

import android.content.Context
import android.content.Intent
import android.support.annotation.DrawableRes


abstract class NotificationConfig(
        // style
        val notificationStyle: NotificationStyle,

        // channel
        val notificationChannelConfig: NotificationChannelConfig,

        // basic
        val context: Context,
        val title: String,
        val text: String,
        @DrawableRes val smallIcon: Int,
        val autoCancel: Boolean,
        val notificationPriority: NotificationPriority,

        // big text
        val bigText: String? = null,

        // intent
        val intent: Intent
) {


    // ------------------------------------------------------------
    // -------------         BasicNotificationConfig
    // ------------------------------------------------------------
    open class BasicNotificationConfig(context: Context,
                                       notificationChannelConfig: NotificationChannelConfig,
                                       title: String,
                                       text: String,
                                       @DrawableRes smallIcon: Int,
                                       autoCancel: Boolean = true,
                                       notificationPriority: NotificationPriority = NotificationPriority.PRIORITY_DEFAULT,
                                       intent: Intent) :
            NotificationConfig(context = context,
                    notificationChannelConfig = notificationChannelConfig,
                    title = title,
                    text = text,
                    smallIcon = smallIcon,
                    autoCancel = autoCancel,
                    notificationPriority = notificationPriority,
                    notificationStyle = NotificationStyle.BASIC,
                    intent = intent)


    // ------------------------------------------------------------
    // -------------         BigTextNotificationConfig
    // ------------------------------------------------------------
    open class BigTextNotificationConfig(context: Context,
                                         notificationChannelConfig: NotificationChannelConfig,
                                         title: String,
                                         text: String,
                                         bigText: String,
                                         @DrawableRes smallIcon: Int,
                                         autoCancel: Boolean = true,
                                         notificationPriority: NotificationPriority = NotificationPriority.PRIORITY_DEFAULT,
                                         intent: Intent) :
            NotificationConfig(context = context,
                    notificationChannelConfig = notificationChannelConfig,
                    title = title,
                    text = text,
                    bigText = bigText,
                    smallIcon = smallIcon,
                    autoCancel = autoCancel,
                    notificationPriority = notificationPriority,
                    notificationStyle = NotificationStyle.BIG_TEXT,
                    intent = intent)

}