package uz.gita.luis.broadcast

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatImageView
import java.util.jar.Attributes

class CustomSwitch @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle:Int = 0
):AppCompatImageView(context, attrs,defStyle) {

     var isTurnOn:Boolean = true

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    if (isTurnOn) setImageResource(R.drawable.lamp_on)
    else setImageResource(R.drawable.lamp_off)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        invalidate()
        if(isTurnOn == event!!.x > 0){
            isTurnOn = event.x < 0
            invalidate()
        }
        return super.onTouchEvent(event)
    }
}