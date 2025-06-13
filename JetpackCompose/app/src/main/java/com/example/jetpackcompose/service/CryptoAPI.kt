package com.example.jetpackcompose.service

import com.example.jetpackcompose.model.CryptoModel
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {

    //BASE -> https://raw.githubusercontent.com/
    //ENDPOINT -> atilsamancioglu/K21-JSONDataSet/master/crypto.json

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getData() : Call<List<CryptoModel>>

}