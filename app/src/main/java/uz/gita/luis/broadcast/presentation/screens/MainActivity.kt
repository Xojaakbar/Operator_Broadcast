package uz.gita.luis.broadcast.presentation.screens

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import uz.gita.luis.broadcast.R
import uz.gita.luis.broadcast.data.local.SharedPref
import uz.gita.luis.broadcast.databinding.ActivityMainBinding
import uz.gita.luis.broadcast.receiver.Batareyafull
import uz.gita.luis.broadcast.receiver.Batareyakam
import uz.gita.luis.broadcast.receiver.ScreenOff
import uz.gita.luis.broadcast.receiver.ScreenOn
import uz.gita.luis.broadcast.receiver.Pilot
import uz.gita.luis.broadcast.receiver.Zaryaddansugurganda
import uz.gita.luis.broadcast.receiver.Zaryadkagaqoyganda
import uz.gita.luis.broadcast.service.EventService

class MainActivity : AppCompatActivity() {
    private val sharedPref = SharedPref.getInstance()
    private lateinit var clicksound: MediaPlayer
    private val coroutine = CoroutineScope(Dispatchers.IO)

    private var batareyakamIsOn = false
    private var batareyafullIsOn = false
    private var pilotIsOn = false
    private var zaryaddansugurgandaIsOn = false
    private var zaryadkagaqoygandaIsOn = false
    private var screenOnIsOn = false
    private var screenOffIsOn = false

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listeners()
        coroutine.launch {
            batareyakamIsOn = sharedPref.getBatareyakam()
            batareyafullIsOn = sharedPref.getBatareyafull()
            pilotIsOn = sharedPref.getPilot()
            zaryaddansugurgandaIsOn = sharedPref.getZaryaddansugurganda()
            zaryadkagaqoygandaIsOn = sharedPref.getZaryadkagaqoyganda()
            screenOnIsOn = sharedPref.getScreenOn()
            screenOffIsOn = sharedPref.getScreenOff()
        }
        states()
    }

    private fun states(){
//        binding.dataOzgarganda.setImageResource(if (dataChangedIsOn) R.drawable.lamp_on else R.drawable.lamp_off)
        binding.batareyasiKamQoganda.setImageResource(if (batareyakamIsOn) R.drawable.lamp_on else R.drawable.lamp_off)
        binding.batareyasiFullBoganda.setImageResource(if (batareyafullIsOn) R.drawable.lamp_on else R.drawable.lamp_off)
        binding.ekranOchganda.setImageResource(if ( sharedPref.getScreenOff()) R.drawable.lamp_on else R.drawable.lamp_off)
        binding.ekranYonganda.setImageResource(if (screenOnIsOn) R.drawable.lamp_on else R.drawable.lamp_off)
        binding.poletgaSoganda.setImageResource(if (pilotIsOn) R.drawable.lamp_on else R.drawable.lamp_off)
        binding.ekranYonganda.setImageResource(if ( sharedPref.getScreenOn()) R.drawable.lamp_on else R.drawable.lamp_off)
        binding.zaryadOganda.setImageResource(if (zaryadkagaqoygandaIsOn) R.drawable.lamp_on else R.drawable.lamp_off)
        binding.zaryaddanSugurganda.setImageResource(if (zaryaddansugurgandaIsOn) R.drawable.lamp_on else R.drawable.lamp_off)
//        binding.wifiOnLamp.setImageResource(if ( wifiOnIsOn) R.drawable.lamp_on else R.drawable.lamp_off)
//        binding.wifiOfLamp.setImageResource(if ( wifiOffIsOn) R.drawable.lamp_on else R.drawable.lamp_off)

    }

    private fun listeners(){
//        binding.dataOzgarganda.setOnClickListener {
//            dataChangedIsOn = !dataChangedIsOn
//            clickedSound(dataChangedIsOn,it as ImageView)
//            serviceCommand(DataChanged.ACTION)
//        }
        binding.batareyasiKamQoganda.setOnClickListener {
            batareyakamIsOn = !batareyakamIsOn
            clickedSound(batareyakamIsOn,it as ImageView)
            serviceCommand(Batareyakam.ACTION)
            sharedPref.putBatareyakam(batareyakamIsOn)
        }
        binding.batareyasiFullBoganda.setOnClickListener {
            batareyafullIsOn = !batareyafullIsOn
            clickedSound(batareyafullIsOn,it as ImageView)
            serviceCommand(Batareyafull.ACTION)
            sharedPref.putBatareyafull(batareyafullIsOn)
        }
        binding.ekranOchganda.setOnClickListener {
            screenOffIsOn = !screenOffIsOn
            clickedSound(screenOffIsOn,it as ImageView)
            serviceCommand(ScreenOff.ACTION)
            sharedPref.putScreenOff(screenOffIsOn)
        }
        binding.ekranYonganda.setOnClickListener {
            screenOnIsOn = !screenOnIsOn
            clickedSound(screenOnIsOn,it as ImageView)
            serviceCommand(ScreenOn.ACTION)
            sharedPref.putScreenOn(screenOnIsOn)
        }
        binding.poletgaSoganda.setOnClickListener {
            pilotIsOn = !pilotIsOn
            clickedSound(pilotIsOn,it as ImageView)
            serviceCommand(Pilot.ACTION)
            sharedPref.putPilot(pilotIsOn)
        }
        binding.zaryadOganda.setOnClickListener {
            zaryadkagaqoygandaIsOn = !zaryadkagaqoygandaIsOn
            clickedSound(zaryadkagaqoygandaIsOn,it as ImageView)
            serviceCommand(Zaryadkagaqoyganda.ACTION)
            sharedPref.putZaryadkagaqoyganda(zaryadkagaqoygandaIsOn)
        }
        binding.zaryaddanSugurganda.setOnClickListener {
            zaryaddansugurgandaIsOn = !zaryaddansugurgandaIsOn
            clickedSound(zaryaddansugurgandaIsOn,it as ImageView)
            serviceCommand(Zaryaddansugurganda.ACTION)
            sharedPref.putZaryaddansugurganda(zaryaddansugurgandaIsOn)
        }
//        binding.wifiOnLamp.setOnClickListener {
//            wifiOnIsOn = !wifiOnIsOn
//            clickedSound(wifiOnIsOn,it as ImageView)
//            serviceCommand(WifiOn.ACTION)
//        }
//        binding.wifiOfLamp.setOnClickListener {
//            wifiOffIsOn = !wifiOffIsOn
//            clickedSound(wifiOffIsOn,it as ImageView)
//            serviceCommand(WifiOff.ACTION)
//        }

        binding.more.setOnClickListener {
            showDialogOne()
        }
    }

    private fun clickedSound(boolean: Boolean, imageView: ImageView){
        if(boolean){
            imageView.setImageResource(R.drawable.lamp_on)
            clicksound = MediaPlayer.create(this, R.raw.sound1)
            clicksound.setVolume(1f,1f)
            clicksound.start()
        }
        else{
            imageView.setImageResource(R.drawable.lamp_off)
            clicksound = MediaPlayer.create(this, R.raw.off)
            clicksound.setVolume(0.1F,0.1F)
            clicksound.start()
        }
    }

    private fun serviceCommand(intentAction: String){

        val intent = Intent(this, EventService::class.java)
        intent.putExtra("ACTION", intentAction)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (requestPermission()){
            startForegroundService(intent)}
        } else {
            startService(intent)
        }
    }

    private fun requestPermission(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    android.Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                myPermissionRequest.launch(android.Manifest.permission.POST_NOTIFICATIONS)
                return false
            }
        }
        return true
    }

    private val myPermissionRequest =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { }

    private fun showDialogOne() {

        val dialog = BottomSheetDialog(this)
        dialog.setContentView(R.layout.dialog_bottom)
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val share = dialog.findViewById<AppCompatTextView>(R.id.share_app)
        val rate = dialog.findViewById<AppCompatTextView>(R.id.rate_app)
        val feedback = dialog.findViewById<AppCompatTextView>(R.id.feedback)

        share?.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val body = "https://play.google.com/store/apps/details?id=uz.gita.luis.broadcast"
            intent.putExtra(Intent.EXTRA_TEXT, body)
            startActivity(Intent.createChooser(intent, "Operator"))
        }
        rate?.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=${packageName}")
                )
            )
        }
        feedback?.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "luis9026076@gmail.com"))
            startActivity(emailIntent)
        }
        dialog.show()
    }
}
