package com.chatai.certifandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chatai.certifandroid.Models.Dish
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_command.view.*

class AdapterListCommand (myCommand: List<Dish>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var myCommandList: List<Dish> = myCommand

    class MyDishViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_command, parent, false)) {

        private val imgDish = itemView.iv_dish
        private val nameDish = itemView.tv_name
        private val quantityDish = itemView.tv_quantity


        fun bind(dish: Dish) {
            Picasso.get().load(dish.img).resize(50,50).centerCrop().into(imgDish)
            nameDish.setText(dish.name)
            quantityDish.setText("x " + dish.quantity.toString())

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDishViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyDishViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is MyDishViewHolder -> {
                holder.bind(myCommandList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return myCommandList.size
    }
}