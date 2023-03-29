package com.example.sleeptracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        findViewById<Button>(R.id.submit_btn).setOnClickListener{
            val date = findViewById<EditText>(R.id.date_tv).text.toString()
            val hour = findViewById<EditText>(R.id.hour_tv).text.toString()

            lifecycleScope.launch(Dispatchers.IO) {
                (application as MyApplication).db.sleepDao().insert(
                    Sleep(date,hour)
                )
            }

            val i = Intent(this@DetailActivity, MainActivity::class.java)
            startActivity(i)
        }

    }
}