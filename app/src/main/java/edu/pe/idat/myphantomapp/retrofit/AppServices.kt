package edu.pe.idat.myphantomapp.retrofit

import edu.pe.idat.myphantomapp.retrofit.requests.RequestLogin
import edu.pe.idat.myphantomapp.retrofit.requests.RequestUser
import edu.pe.idat.myphantomapp.retrofit.responses.ResponseListProducts
import edu.pe.idat.myphantomapp.retrofit.responses.ResponseLogin
import edu.pe.idat.myphantomapp.retrofit.responses.ResponseUser
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AppServices {

    @POST("auth/local")
    fun login(@Body requestLogin: RequestLogin): Call<ResponseLogin>

    @POST("users")
    fun createUser(@Body requestUser: RequestUser): Call<ResponseUser>

    @GET("products?populate=*")
    fun listAllProducts(): Call<ResponseListProducts>
}