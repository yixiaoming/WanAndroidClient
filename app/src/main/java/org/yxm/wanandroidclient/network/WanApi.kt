package org.yxm.wanandroidclient.network

import org.yxm.wanandroidclient.network.entity.WanResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface WanApi {

    @GET("article/list/{page}/json")
    suspend fun getMainPage(@Path("page") page: Int): WanResponse
}