package edu.pe.idat.myphantomapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import edu.pe.idat.myphantomapp.retrofit.AppClient
import edu.pe.idat.myphantomapp.retrofit.requests.RequestLogin
import edu.pe.idat.myphantomapp.retrofit.requests.RequestUser
import edu.pe.idat.myphantomapp.retrofit.responses.ResponseLogin
import edu.pe.idat.myphantomapp.retrofit.responses.ResponseUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository {

    var loginResponse = MutableLiveData<ResponseLogin>()
    var userResponse = MutableLiveData<ResponseUser>()

    fun authenticateUser(requestLogin: RequestLogin):MutableLiveData<ResponseLogin>{
        val call: Call<ResponseLogin> = AppClient.retrofitService.login(requestLogin)

        call.enqueue(object : Callback<ResponseLogin>{
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                loginResponse.value = response.body()
            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Log.e("Error on login ********", t.message.toString())
            }
        })
        return loginResponse
    }

    fun createUser(requestUser: RequestUser): MutableLiveData<ResponseUser>{
        val call: Call<ResponseUser> = AppClient.retrofitService.createUser(requestUser)

        call.enqueue(object : Callback<ResponseUser>{
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                userResponse.value = response.body()
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                Log.e("Error on createUser ********", t.message.toString())
            }

        })
        return userResponse
    }
}