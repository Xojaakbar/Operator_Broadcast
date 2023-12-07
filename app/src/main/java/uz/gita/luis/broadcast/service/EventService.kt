package uz.gita.luis.broadcast.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import uz.gita.luis.broadcast.presentation.screens.MainActivity
import uz.gita.luis.broadcast.R
import uz.gita.luis.broadcast.data.local.SharedPref
import uz.gita.luis.broadcast.receiver.Batareyafull
import uz.gita.luis.broadcast.receiver.Batareyakam
import uz.gita.luis.broadcast.receiver.ScreenOff
import uz.gita.luis.broadcast.receiver.ScreenOn
import uz.gita.luis.broadcast.receiver.Pilot
import uz.gita.luis.broadcast.receiver.Zaryaddansugurganda
import uz.gita.luis.broadcast.receiver.Zaryadkagaqoyganda
import java.lang.Exception

/*
created by Xo'jaakbar on 06.07.2023 at 15:32
*/

class EventService: Service() {

    private val sharedpref = SharedPref.getInstance()

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel()
        }
        createNotificationAndStartService()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.extras?.getString("ACTION")) {
            Batareyakam.ACTION -> {
                if (!sharedpref.getBatareyakam()) {
                    try {
                        sharedpref.putBatareyakam(false)
                        unregisterReceiver(Batareyakam)
                    }
                    catch (e:Exception){  }

                } else {
                    registerReceiver(Batareyakam, IntentFilter().apply {
                        addAction(Batareyakam.ACTION)
                    })
                    sharedpref.putBatareyakam(true)
                }
            }

            Batareyafull.ACTION -> {
                if (!sharedpref.getBatareyafull()){
                    try {
                        sharedpref.putBatareyafull(false)
                        unregisterReceiver(Batareyafull)
                    }
                    catch (e:Exception){}

                } else{
                    registerReceiver(Batareyafull,IntentFilter().apply {
                        addAction(Batareyafull.ACTION)
                    })
                    sharedpref.putBatareyafull(false)
                }
            }
            Zaryadkagaqoyganda.ACTION -> {
                if (!sharedpref.getZaryadkagaqoyganda()){
                    try {
                        sharedpref.putZaryadkagaqoyganda(false)
                        unregisterReceiver(Zaryadkagaqoyganda)}
                    catch (e:Exception){}

                } else{
                    registerReceiver(Zaryadkagaqoyganda,IntentFilter().apply {
                        addAction(Zaryadkagaqoyganda.ACTION)
                    })
                    sharedpref.putZaryadkagaqoyganda(false)
                }
            }
            Zaryaddansugurganda.ACTION -> {
                if (!sharedpref.getZaryaddansugurganda()){
                    try {
                        sharedpref.putZaryaddansugurganda(false)
                        unregisterReceiver(Zaryaddansugurganda)}
                    catch (e:Exception){}

                } else{
                    registerReceiver(Zaryaddansugurganda,IntentFilter().apply {
                        addAction(Zaryaddansugurganda.ACTION)
                    })
                    sharedpref.putZaryaddansugurganda(false)
                }
            }
            ScreenOn.ACTION -> {
                if (!sharedpref.getScreenOn()){
                    try {
                        sharedpref.putScreenOn(false)
                        unregisterReceiver(ScreenOn)}
                    catch (e:Exception){}

                } else{
                    registerReceiver(ScreenOn,IntentFilter().apply {
                        addAction(ScreenOn.ACTION)
                    })
                    sharedpref.putScreenOn(false)
                }
            }
            ScreenOff.ACTION -> {
                if (!sharedpref.getScreenOff()){
                    try {
                        sharedpref.putScreenOff(false)
                        unregisterReceiver(ScreenOff)}
                    catch (e:Exception){}
                } else{
                    registerReceiver(ScreenOff,IntentFilter().apply {
                        addAction(ScreenOff.ACTION)
                    })
                    sharedpref.putScreenOff(false)
                }
            }
            Pilot.ACTION -> {
                if (!sharedpref.getPilot()){
                    try {
                        sharedpref.putPilot(false)
                        unregisterReceiver(Pilot)}
                    catch (e:Exception){}

                } else{
                    registerReceiver(Pilot,IntentFilter().apply {
                        addAction(Pilot.ACTION)
                    })
                    sharedpref.putPilot(false)
                }
            }
//            DataChanged.ACTION -> {
//                if (sharedpref.getDataChanged()){
//                    unregisterReceiver(DataChanged)
//                    sharedpref.putDataChanged(false)
//                } else{
//                    registerReceiver(DataChanged,IntentFilter().apply {
//                        addAction(DataChanged.ACTION)
//                    })
//                    sharedpref.putDataChanged(false)
//                }
//            }
        }
        return START_NOT_STICKY
    }

    private fun createNotificationAndStartService() {

        val notifyIntent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent = PendingIntent
            .getActivity(
                this,
                0,
                notifyIntent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

        val notification = NotificationCompat
            .Builder(this, "EventNotificationChannel")
            .setContentTitle("")
            .setSmallIcon(R.drawable.operator_girl2)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(2, notification)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun createChannel() {
        val channel =
            NotificationChannel("EventNotificationChannel",
                "Events",
                NotificationManager.IMPORTANCE_DEFAULT
            )
        channel.setSound(null, null)
        val service = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        service.createNotificationChannel(channel)
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            unregisterReceiver(Batareyakam)
        } catch (e:Exception){

        }
        try {
            unregisterReceiver(Batareyafull)
        } catch (e:Exception){

        }
        try {
            unregisterReceiver(Zaryaddansugurganda)
        } catch (e:Exception){

        }
        try {
            unregisterReceiver(Zaryadkagaqoyganda)
        } catch (e:Exception){

        }
//        try {
//            unregisterReceiver(DataChanged)
//        } catch (e:Exception){
//
//        }
        try {
            unregisterReceiver(Pilot)
        } catch (e:Exception){

        }
        try {
            unregisterReceiver(ScreenOff)
        } catch (e:Exception){

        }
        try {
            unregisterReceiver(ScreenOn)
        } catch (e:Exception){

        }
//        try {
//            unregisterReceiver(WifiOn)
//        } catch (e:Exception){
//
//        }
//        try {
//            unregisterReceiver(WifiOff)
//        } catch (e:Exception){
//
//        }
    }
}