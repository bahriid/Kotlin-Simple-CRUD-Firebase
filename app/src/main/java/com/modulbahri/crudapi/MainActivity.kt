package com.modulbahri.crudapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.modulbahri.crudapi.ModulCreate.CreateActivity
import com.modulbahri.crudapi.ModulRead.ReadActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input.setOnClickListener{
            val intent = Intent(this@MainActivity, CreateActivity::class.java)
            startActivity(intent)
        }

        read.setOnClickListener{
            val intent = Intent(this@MainActivity, ReadActivity::class.java)
            startActivity(intent)
        }

    }
}
