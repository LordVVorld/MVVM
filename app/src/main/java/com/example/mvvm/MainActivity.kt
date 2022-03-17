package com.example.mvvm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView?>(R.id.rView).apply {
            layoutManager = LinearLayoutManager(this.context)
            val model: MainViewModel by viewModels()
            adapter = model.getAdapter()
        }
    }
}