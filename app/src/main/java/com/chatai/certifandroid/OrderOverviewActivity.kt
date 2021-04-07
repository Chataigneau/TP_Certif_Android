package com.chatai.certifandroid

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.chatai.certifandroid.Data.ApiClient
import com.chatai.certifandroid.Data.CommandSource
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_command_overview.*
import kotlinx.coroutines.*

class OrderOverviewActivity : AppCompatActivity() {

    //private val myCommand = CommandSource.createCommand()
    private val myCommandList = CommandSource.createDataSet()
    var page : Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_command_overview)
        init()
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
                        this@OrderOverviewActivity,
                        "Error Occurred: ${response.message()}",
                        Toast.LENGTH_LONG
                    ).show()
                }

            } catch (e: Exception) {
                Toast.makeText(
                    this@OrderOverviewActivity,
                    "Error Occurred: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun init(){
        executeCall()
        rv_command_list.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = AdapterListCommand(myCommandList)
        }

        vp_horizontal.adapter = AdapterViewPager(this@OrderOverviewActivity)
        TabLayoutMediator(tabDots, vp_horizontal, TabLayoutMediator.TabConfigurationStrategy { _, _ -> }).attach()
        vp_horizontal.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                page = position+1
                val mSnackbar = Snackbar.make(parent_view, "Plat n° " + (position + 1), Snackbar.LENGTH_SHORT)
                val mView: View = mSnackbar.view
                val mTextView = mView.findViewById<View>(com.google.android.material.R.id.snackbar_text) as TextView
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
                    mTextView.textAlignment =
                        View.TEXT_ALIGNMENT_CENTER
                } else mTextView.gravity =
                    Gravity.CENTER_HORIZONTAL
                mSnackbar.show()
            }
        })
    }
}