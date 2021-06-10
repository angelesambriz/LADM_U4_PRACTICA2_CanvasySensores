package mx.tecnm.tepic.ladm_u4_practica2_canvasysensores

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

var dato = 0
class MainActivity : AppCompatActivity(),SensorEventListener{
    var lienzo  : Lienzo ?= null
    lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lienzo = Lienzo(this)
        setContentView(lienzo!!)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_GAME)
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
            SensorManager.SENSOR_DELAY_GAME)
    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent) {
        if(event.sensor.type == Sensor.TYPE_ACCELEROMETER){
            if (lienzo!!.estrella1.x.toInt() - (event.values[0].toInt() * 3) <= 0) {
            } else if (lienzo!!.estrella1.x.toInt() - (event.values[0].toInt() * 3) < (720 - lienzo!!.estrella1.ancho)) {
                lienzo!!.estrella1.moverX(lienzo!!.estrella1.x.toInt() - (event.values[0].toInt() * 3))
                lienzo!!.invalidate()
            }
        }
        if(event.sensor.type == Sensor.TYPE_PROXIMITY){
            if(event.values[0]<4){
                lienzo!!.estrella1.cambiarImagen(lienzo!!.estrellita2)
                dato=1
            }
            if(event.values[0]>=4){
                lienzo!!.estrella1.cambiarImagen(lienzo!!.estrellita)
                dato=2
            }
        }

    }
}