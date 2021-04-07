package com.chatai.certifandroid.Data

import com.chatai.certifandroid.Models.Command
import com.chatai.certifandroid.Models.Dish
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.collections.ArrayList

class CommandSource{

    companion object{

        fun createCommand() : Command{
            val dateNow = LocalDateTime.now()
            
            val formatTime =  DateTimeFormatter.ofPattern("HH:mm")
            val formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy")

            val hour = dateNow.format(formatTime)
            val date = dateNow.format(formatDate)

            val myDishInCommand = createDataSet()

            return Command("Michel Sarran", myDishInCommand,hour,date)
        }

        fun createDataSet(): ArrayList<Dish>{
            val list = ArrayList<Dish>()
            list.add(
                Dish(
                    "https://www.icone-png.com/png/38/37948.png",
                    "Oeufs bacon",
                    1)
            )
            list.add(
                Dish(
                    "https://www.icone-png.com/png/38/37960.png",
                    "Salade du chef",
                    2)
            )

            list.add(
                Dish(
                    "https://www.icone-png.com/png/38/37952.png",
                    "La pièce 500g",
                    1)
            )
            return list
        }
    }
}