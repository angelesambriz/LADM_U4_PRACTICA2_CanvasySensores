package mx.tecnm.tepic.ladm_u4_practica2_canvasysensores


import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.view.Display
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService

class Lienzo(p:MainActivity) : View(p) {

    var estrellita = BitmapFactory.decodeResource(resources,R.drawable.estrellita)
    var estrellita2 = BitmapFactory.decodeResource(resources,R.drawable.estrellita2)
    var estrella1 = Figura(20,600,estrellita)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()

        if (dato==2){
            canvas.drawColor(Color.CYAN)
            estrella1.cambiarImagen(estrellita)
        }
        if (dato==1){canvas.drawColor(Color.BLACK)
            estrella1.cambiarImagen(estrellita2)
        }

        estrella1.pintar(canvas,paint)
        estrella1.cambiarImagen(estrellita2)
        estrella1.cambiarImagen(estrellita)

    }
}