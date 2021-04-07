package com.chatai.certifandroid

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.chatai.certifandroid.Data.ApiClient
import com.chatai.certifandroid.Data.CommandSource
import kotlinx.android.synthetic.main.activity_command_overview.*
import kotlinx.coroutines.*

class CommandOverviewActivity : AppCompatActivity() {

    //private val myCommand = CommandSource.createCommand()
    private val myCommandList = CommandSource.createDataSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_command_overview)

        executeCall()

        rv_command_list.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = AdapterListCommand(myCommandList)
        }
    }

    private fun executeCall() {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val response = ApiClient.apiService.getOrders()

                if (response.isSuccessful && response.body() != null) {
                    val content = response.body()
                    //do something
                } else {
                    Toast.makeText(
                        this@CommandOverviewActivity,
                        "Error Occurred: ${response.message()}",
                        Toast.LENGTH_LONG
                    ).show()
                }

            } catch (e: Exception) {
                Toast.makeText(
                    this@CommandOverviewActivity,
                    "Error Occurred: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}