package com.chatai.certifandroid.Data.Models

import java.util.*

data class Command (var meals : List<Meal>,
                    var price : Int,
                    var dueDate : Date
)