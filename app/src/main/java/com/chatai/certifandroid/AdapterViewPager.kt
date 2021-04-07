package com.chatai.certifandroid

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_page.view.*

class AdapterViewPager(var context : Context) : RecyclerView.Adapter<AdapterViewPager.MyViewHolder>(){

    var color_icon_meals = arrayOf<IntArray>(
        intArrayOf(android.R.color.holo_blue_light,R.drawable.eggs),
        intArrayOf(android.R.color.holo_blue_light,R.drawable.salade),
        intArrayOf(android.R.color.holo_blue_light,R.drawable.meat)
    )

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var imgMeal : ImageView
        var container : ConstraintLayout

        init {
            imgMeal = itemView.iv_meal_vp
            container = itemView.cl_page
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewPager.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_page,parent,false))
    }

    override fun getItemCount(): Int {
        return color_icon_meals.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imgMeal.setImageResource(color_icon_meals[position][1])
        holder.container.setBackgroundResource(color_icon_meals[position][0])

        val context = holder.itemView.context as Activity

        holder.imgMeal.setOnClickListener{
            val intent = Intent(context, MealOverviewActivity::class.java)
            intent.putExtra("meal",position+1)
            context.startActivity(intent)
        }
    }
}