package com.example.sleeptracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sleeptracker.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val sleepList = mutableListOf<Sleep>()
    private lateinit var sleepRv : RecyclerView
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(R.layout.activity_main)

        sleepRv = findViewById(R.id.list_rv)
        val sleepAdapter = SleepAdapter(this,sleepList)
        sleepRv.adapter = sleepAdapter

        lifecycleScope.launch{

            (application as MyApplication).db.sleepDao().getAll().collect{ databaseList ->
                databaseList.map { mappedList ->
                    sleepList.addAll(listOf(mappedList))
                    sleepAdapter.notifyDataSetChanged()
                }

            }
        }

        sleepRv.layoutManager = LinearLayoutManager(this)
        val addBtn = findViewById<Button>(R.id.add_btn)
        addBtn.setOnClickListener{
            val i = Intent(this@MainActivity, DetailActivity::class.java)
            startActivity(i)
        }

    }
}