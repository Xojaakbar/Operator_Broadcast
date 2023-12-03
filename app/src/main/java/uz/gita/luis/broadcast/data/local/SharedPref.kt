package uz.gita.luis.broadcast.data.local

import android.content.Context
import android.content.SharedPreferences

class SharedPref private constructor() {
        private val editor = pref.edit()
        companion object {
            private lateinit var instance: SharedPref
            private lateinit var pref:SharedPreferences

            fun init (context: Context){
               pref = context.getSharedPreferences("Receiver", Context.MODE_PRIVATE)
            }
            fun getInstance(): SharedPref {
                if (!(Companion::instance.isInitialized)){
                    instance = SharedPref()
                }
                return instance
            }
        }

//        fun putWifiOn(state: Boolean) {
//            editor.putBoolean("WifiOn", state).apply()
//        }
//        fun getWifiOn():Boolean = pref.getBoolean("WifiOn",false)
//
//        fun putWifiOff(state: Boolean) {
//            editor.putBoolean("WifiOff", state).apply()
//        }
//        fun getWifiOff():Boolean = pref.getBoolean("WifiOff",false)

//        fun putDataChanged(state: Boolean) {
//            editor.putBoolean("DataChanged", state).apply()
//        }
//        fun getDataChanged():Boolean = pref.getBoolean("DataChanged",false)

        fun putPilot(state: Boolean) {
            editor.putBoolean("Pilot", state).apply()
        }
        fun getPilot():Boolean = pref.getBoolean("Pilot",false)

        fun putTimeChanged(state: Boolean) {
            editor.putBoolean("TimeChanged", state).apply()
        }
        fun getTimeChanged():Boolean = pref.getBoolean("TimeChanged",false)

        fun putBatareyakam(state: Boolean) {
            editor.putBoolean("Batareyakam", state).apply()
        }
        fun getBatareyakam():Boolean = pref.getBoolean("Batareyakam",false)

        fun putBatareyafull(state: Boolean) {
            editor.putBoolean("Batareyafull", state).apply()
        }
        fun getBatareyafull():Boolean = pref.getBoolean("Batareyafull",false)

        fun putEkranOn(state: Boolean) {
            editor.putBoolean("EkranOn", state).apply()
        }
        fun getEkranOn():Boolean = pref.getBoolean("EkranOn",false)

        fun putEkranOff(state: Boolean) {
            editor.putBoolean("EkranOff", state).apply()
        }
        fun getEkranOff():Boolean = pref.getBoolean("EkranOff",false)

        fun putZaryadkagaqoyganda(state: Boolean) {
            editor.putBoolean("Zaryadkagaqoyganda", state).apply()
        }
        fun getZaryadkagaqoyganda():Boolean = pref.getBoolean("Zaryadkagaqoyganda",false)

        fun putZaryaddansugurganda(state: Boolean) {
            editor.putBoolean("Zaryaddansugurganda", state).apply()
        }
        fun getZaryaddansugurganda():Boolean = pref.getBoolean("Zaryaddansugurganda",false)


}