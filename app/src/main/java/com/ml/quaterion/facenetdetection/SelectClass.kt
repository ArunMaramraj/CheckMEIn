package com.ml.quaterion.facenetdetection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ml.quaterion.facenetdetection.MainActivity.Companion.url

class SelectClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.class_activity)

        val testimagesButton = findViewById<Button>(R.id.testimages_button)
        val classBButton = findViewById<Button>(R.id.classB_button)
        val classCButton = findViewById<Button>(R.id.classC_button)

        testimagesButton.setOnClickListener {
            startAttendanceActivity(" ") // enter the corresponding directory url in the firebase storage bucket
        }

        classBButton.setOnClickListener {
            startAttendanceActivity(" ") // enter the corresponding directory url in the firebase storage bucket
        }

        classCButton.setOnClickListener {
            startAttendanceActivity(" ") // enter the corresponding directory url in the firebase storage bucket
        }



    }

    private fun startAttendanceActivity(className: String) {
        val intent = Intent(this, MainActivity::class.java)
        url = className
        startActivity(intent)
    }
}
