package com.chatai.certifandroid.Models

import java.util.*

data class Command (var restaurant : String,
                    var listDish: List<Dish>,
                    var time : String,
                    var date : String)