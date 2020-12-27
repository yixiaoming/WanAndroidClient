package org.yxm.wanandroidclient.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {

    private const val BASE_URL = "https://www.wanandroid.com/"
    private val wanApi: WanApi

    init {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(StringConverterFactory())
            .baseUrl(BASE_URL)
            .build()
        wanApi = retrofit.create(WanApi::class.java)
    }

    fun wanApi(): WanApi {
        return wanApi
    }
}