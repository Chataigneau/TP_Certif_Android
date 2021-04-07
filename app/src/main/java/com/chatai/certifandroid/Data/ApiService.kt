package com.chatai.certifandroid.Data

import com.chatai.certifandroid.Data.Models.Command
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("orders")
    suspend fun getOrders(): Response<MutableList<Command>>
}