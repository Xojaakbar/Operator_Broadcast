package uz.gita.luis.broadcast.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import uz.gita.luis.broadcast.R
import uz.gita.luis.broadcast.data.local.SharedPref

private lateinit var mediaPlayer: MediaPlayer
private val sharedPref = SharedPref.getInstance()

//object WifiOn : BroadcastReceiver() {
//
//    const val ACTION = Intent.ACTION_BATTERY_LOW
//
//    override fun onReceive(context: Context?, intent: Intent?) {
//        when (intent?.action) {
//            WifiManager.NETWORK_STATE_CHANGED_ACTION -> {
//                val mediaPlayer = MediaPlayer.create(context, R.raw.wifi_on)
//                mediaPlayer.start()
//            }
//        }
//    }
//}
//
//class WifiStateReceiver : BroadcastReceiver() {
//    override fun onReceive(context: Context?, intent: Intent?) {
//        when (intent?.action) {
//            WifiManager.WIFI_STATE_CHANGED_ACTION -> {
//                val wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN)
//                when (wifiState) {
//                    WifiManager.WIFI_STATE_ENABLED -> {
//                        // Wi-Fi is enabled
//                    }
//                    WifiManager.WIFI_STATE_DISABLED -> {
//                        // Wi-Fi is disabled
//                    }
//                }
//            }
//        }
//    }
//}
//
//object WifiOff : BroadcastReceiver() {
//
//    const val ACTION = Intent.ACTION_BOOT_COMPLETED //todo
//
//    override fun onReceive(context: Context?, intent: Intent?) {
//        when (intent?.action) {
//            Intent.ACTION_BATTERY_LOW -> {
//                val mediaPlayer = MediaPlayer.create(context, R.raw.wifi_off)
//                mediaPlayer.start()
//            }
//        }
//    }
//}

object Batareyakam : BroadcastReceiver() {

    const val ACTION = Intent.ACTION_LOCKED_BOOT_COMPLETED

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_BATTERY_LOW -> {
                val mediaPlayer = MediaPlayer.create(context, R.raw.battery_low)
                mediaPlayer.start()
            }
        }
    }
}

object Batareyafull : BroadcastReceiver() {

    const val ACTION = Intent.ACTION_BATTERY_OKAY

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_BATTERY_OKAY -> {
                val mediaPlayer = MediaPlayer.create(context, R.raw.nimaqilishkerak)
                mediaPlayer.start()
            }
        }
    }
}

object Zaryadkagaqoyganda : BroadcastReceiver() {

    const val ACTION = Intent.ACTION_POWER_CONNECTED

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_POWER_CONNECTED -> {
                val mediaPlayer = MediaPlayer.create(context, R.raw.power_connected)
                mediaPlayer.start()
            }
        }
    }
}

object Zaryaddansugurganda : BroadcastReceiver() {

    const val ACTION = Intent.ACTION_POWER_DISCONNECTED

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_POWER_DISCONNECTED -> {
                val mediaPlayer = MediaPlayer.create(context, R.raw.power_disconnected)
                mediaPlayer.start()}
        }
    }
}

object ScreenOn : BroadcastReceiver() {

    const val ACTION = Intent.ACTION_SCREEN_ON

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_SCREEN_ON -> {
                Log.d("TTT", "Ekran On Receiver")
                val mediaPlayer = MediaPlayer.create(context, R.raw.screen_on)
                mediaPlayer.start()
            }
        }
    }
}

object ScreenOff : BroadcastReceiver() {

    const val ACTION = Intent.ACTION_SCREEN_OFF

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_SCREEN_OFF -> {
                Log.d("TTT", "EkranOff Receiver")
                val mediaPlayer = MediaPlayer.create(context, R.raw.screen_off)
                mediaPlayer.start()
            }
        }
    }
}

object Pilot : BroadcastReceiver() {

    const val ACTION = Intent.ACTION_AIRPLANE_MODE_CHANGED

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                    val mediaPlayer = MediaPlayer.create(context, R.raw.airplane_on)
                    mediaPlayer.start()
            }
        }
    }
}

//object DataChanged:BroadcastReceiver(){
//
//    const val ACTION = Intent.ACTION_DATE_CHANGED
//    override fun onReceive(context: Context?, intent: Intent?) {
//        when (intent?.action) {
//            Intent.ACTION_DATE_CHANGED -> {
//                    val mediaPlayer = MediaPlayer.create(context, R.raw.switched)
//                    mediaPlayer.start()
//            }
//        }
//    }
//}

//
//object LowStorage:BroadcastReceiver(){
//    const val ACTION = Intent.ACTION_DEVICE_STORAGE_LOW
//    override fun onReceive(context: Context?, intent: Intent?) {
//        when (intent?.action) {
//            Intent.ACTION_DEVICE_STORAGE_LOW -> {
//                    val mediaPlayer = MediaPlayer.create(context, R.raw.switched)
//                    mediaPlayer.start()
//            }
//        }
//    }
//}

