package com.example.network

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getBitmapFromURL("https://i.redd.it/rzjuj3y568h81.jpg")
        }
    private fun getBitmapFromURL(src:String):Bitmap? {
        val img_01 = findViewById<ImageView>(R.id.imgV_01)
        val excutor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        var image: Bitmap? = null
        excutor.execute {
            val imageURL = src
            try {
                val a = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(a)
                handler.post {
                    img_01.setImageBitmap(image)
                }
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }
        return null
    }
    }


