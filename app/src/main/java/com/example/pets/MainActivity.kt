package com.example.pets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    var mes: List<String> = listOf()

    fun text()= runBlocking {
        GlobalScope.launch{
            mes = RetrofitClient().service.getBreeds()?.body()?.message!!
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        val btn1 = findViewById<Button>(R.id.btn1)
        val image = findViewById<ImageView>(R.id.image)
        val txt1 = findViewById<TextView>(R.id.txt1)
        val txt2 = findViewById<TextView>(R.id.txt2)
        val txt3 = findViewById<TextView>(R.id.txt3)
        val txt4 = findViewById<TextView>(R.id.txt4)
        val txt5 = findViewById<TextView>(R.id.txt5)
        val txt6 = findViewById<TextView>(R.id.txt6)
        val txt7 = findViewById<TextView>(R.id.txt7)
        val txt8 = findViewById<TextView>(R.id.txt8)
        val txt9 = findViewById<TextView>(R.id.txt9)
        val txt10 = findViewById<TextView>(R.id.txt10)
        val intent = Intent(this, SecondPage::class.java)
        var breed = ""
        text()
        btn1.setOnClickListener {
            Picasso.get().load(mes[0]).into(image)
            breed = mes[1].substring(30).substringBefore('/').replaceFirstChar{it.titlecase()}
            txt1.setText(breed)
            breed = mes[2].substring(30).substringBefore('/').replaceFirstChar{it.titlecase()}
            txt2.setText(breed)
            breed = mes[3].substring(30).substringBefore('/').replaceFirstChar{it.titlecase()}
            txt3.setText(breed)
            breed = mes[4].substring(30).substringBefore('/').replaceFirstChar{it.titlecase()}
            txt4.setText(breed)
            breed = mes[5].substring(30).substringBefore('/').replaceFirstChar{it.titlecase()}
            txt5.setText(breed)
            breed = mes[6].substring(30).substringBefore('/').replaceFirstChar{it.titlecase()}
            txt6.setText(breed)
            breed = mes[7].substring(30).substringBefore('/').replaceFirstChar{it.titlecase()}
            txt7.setText(breed)
            breed = mes[8].substring(30).substringBefore('/').replaceFirstChar{it.titlecase()}
            txt8.setText(breed)
            breed = mes[9].substring(30).substringBefore('/').replaceFirstChar{it.titlecase()}
            txt9.setText(breed)
            breed = mes[10].substring(30).substringBefore('/').replaceFirstChar{it.titlecase()}
            txt10.setText(breed)
            txt1.setOnClickListener {
                intent.putExtra(SecondPage.LINK, txt1.getText().toString())
                startActivity(intent)
            }
            txt2.setOnClickListener {
                intent.putExtra(SecondPage.LINK, txt2.getText().toString())
                startActivity(intent)
            }
            txt3.setOnClickListener {
                intent.putExtra(SecondPage.LINK, txt3.getText().toString())
                startActivity(intent)
            }
            txt4.setOnClickListener {
                intent.putExtra(SecondPage.LINK, txt4.getText().toString())
                startActivity(intent)
            }
            txt5.setOnClickListener {
                intent.putExtra(SecondPage.LINK, txt5.getText().toString())
                startActivity(intent)
            }
            txt6.setOnClickListener {
                intent.putExtra(SecondPage.LINK, txt6.getText().toString())
                startActivity(intent)
            }
            txt7.setOnClickListener {
                intent.putExtra(SecondPage.LINK, txt7.getText().toString())
                startActivity(intent)
            }
            txt8.setOnClickListener {
                intent.putExtra(SecondPage.LINK, txt8.getText().toString())
                startActivity(intent)
            }
            txt9.setOnClickListener {
                intent.putExtra(SecondPage.LINK, txt9.getText().toString())
                startActivity(intent)
            }
            txt10.setOnClickListener {
                intent.putExtra(SecondPage.LINK, txt10.getText().toString())
                startActivity(intent)
            }
            text()
        }
    }
}