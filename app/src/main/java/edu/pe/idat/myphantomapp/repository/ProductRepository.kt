package edu.pe.idat.myphantomapp.repository


import android.util.Log
import androidx.lifecycle.MutableLiveData
import edu.pe.idat.myphantomapp.retrofit.AppClient
import edu.pe.idat.myphantomapp.retrofit.responses.ResponseListProducts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository {

    var listProductsResponse = MutableLiveData<ResponseListProducts>()

    fun listAllProducts(): MutableLiveData<ResponseListProducts>{
        val call: Call<ResponseListProducts> = AppClient.retrofitService.listAllProducts()

        call.enqueue(object : Callback<ResponseListProducts>{
            override fun onResponse(
                call: Call<ResponseListProducts>,
                response: Response<ResponseListProducts>
            ) {
                listProductsResponse.value = response.body()
            }

            override fun onFailure(call: Call<ResponseListProducts>, t: Throwable) {
                Log.e("Error on list all productos ********", t.message.toString())
            }

        })
        return listProductsResponse
    }
}