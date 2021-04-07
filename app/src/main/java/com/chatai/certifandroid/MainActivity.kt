package com.chatai.certifandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = Handler()
        handler.postDelayed({ changeView() }, 5000)
    }

    private fun changeView(){
        val intent = Intent(this, OrderOverviewActivity::class.java)
        startActivity(intent)
        finish()
    }
}