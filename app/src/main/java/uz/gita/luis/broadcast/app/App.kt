package uz.gita.luis.broadcast.app

import android.app.Application
import uz.gita.luis.broadcast.data.local.SharedPref

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPref.init(this)
    }
}