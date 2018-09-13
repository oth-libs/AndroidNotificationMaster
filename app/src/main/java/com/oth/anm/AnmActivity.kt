package com.oth.anm

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.oth.anm.configuration.NotificationChannelConfig
import com.oth.anm.configuration.NotificationConfig
import com.oth.anm.configuration.NotificationHandler
import kotlinx.android.synthetic.main.activity_anm.*


class AnmActivity : AppCompatActivity() {


    private var lastNotificationId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anm)

        val intent = Intent(this, AnmActivity::class.java)

        clearNotification.setOnClickListener {
            NotificationHandler.clearNotification(this@AnmActivity, lastNotificationId)
        }

        clearAllNotification.setOnClickListener {
            NotificationHandler.clearNotifications(this@AnmActivity)
        }

        basic.setOnClickListener {
            val a = NotificationConfig.BasicNotificationConfig(context = this@AnmActivity,
                    notificationChannelConfig = NotificationChannelConfig(
                            context = this@AnmActivity,
                            channelId = "CHANNEL ID",
                            channelName = "Channel Name",
                            channelDescription = "Channel Description"
                    ),
                    title = "BASIC this is a fucking title",
                    text = "this is a fucking text",
                    smallIcon = R.drawable.ic_launcher,
                    intent = intent)
            lastNotificationId = NotificationHandler(a).show()
        }

        bigText.setOnClickListener {
            val a = NotificationConfig.BigTextNotificationConfig(context = this@AnmActivity,
                    notificationChannelConfig = NotificationChannelConfig(
                            context = this@AnmActivity,
                            channelId = "ANOTHER CHANNEL ID",
                            channelName = "Channel Name 2 yo",
                            channelDescription = "Channel Description blah blah blah"
                    ),
                    title = "BIGTEXT this is a fucking title",
                    text = "this is a fucking text",
                    bigText = "this is a big fucking text, biiiiiig text",
                    smallIcon = R.drawable.ic_launcher,
                    intent = intent)
            lastNotificationId = NotificationHandler(a).show()
        }
    }
}
