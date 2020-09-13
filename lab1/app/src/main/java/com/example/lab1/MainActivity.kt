package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val showButton = findViewById<Button>(R.id.showInput)
        val textView = findViewById<TextView>(R.id.text_view_id)
        val sw1 = findViewById<Switch>(R.id.switch1)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val textLong = findViewById<TextView>(R.id.tv_long)

        val milan = Constants().milan
        val moscow = Constants().moscow

        textLong.setText(milan).toString()

        showButton.setOnClickListener {
            val text = editText.text
            textView.setText(text).toString()
        }

        sw1?.setOnCheckedChangeListener { _, isChecked ->
            val text: String
            val image: Int

            if (isChecked){
                image = R.drawable.mos
                text = moscow
            } else {
                image = R.drawable.milan_1
                text = milan
            }

            imageView.setImageResource(image)
            textLong.setText(text).toString()
        }
    }
}