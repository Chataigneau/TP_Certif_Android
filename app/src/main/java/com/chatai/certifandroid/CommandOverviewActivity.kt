package com.chatai.certifandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.chatai.certifandroid.Data.CommandSource
import kotlinx.android.synthetic.main.activity_command_overview.*

class CommandOverviewActivity : AppCompatActivity() {

    private val myCommand = CommandSource.createCommand()
    private val myCommandList = CommandSource.createDataSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_command_overview)

        tv_restaurant_name.setText(myCommand.restaurant)

        rv_command_list.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = AdapterListCommand(myCommandList)
        }
    }
}