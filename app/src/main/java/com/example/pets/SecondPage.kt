package com.example.pets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.*

class SecondPage : AppCompatActivity() {
    companion object {
        const val LINK = "link"
    }
    var mes = ""

    fun image(img: ImageView, breed: String)= runBlocking {
        GlobalScope.launch{
            mes = RetrofitClient().service.getImage(breed)?.body()?.message!!
            withContext(Dispatchers.Main) {Picasso.get().load(mes).into(img)}
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)
    }

    override fun onStart() {
        super.onStart()

        val link = intent.getStringExtra(LINK).toString().substringBefore('-')
        val txt = findViewById<TextView>(R.id.txt)
        val close = findViewById<TextView>(R.id.close)
        val img = findViewById<ImageView>(R.id.img)
        val btn = findViewById<Button>(R.id.btn)
        txt.setText(link)
        image(img, link.lowercase())
        btn.setOnClickListener {
            image(img, link.lowercase())
        }
        close.setOnClickListener {
            this.finish()
        }
    }
}