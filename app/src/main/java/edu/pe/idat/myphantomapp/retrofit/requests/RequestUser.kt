package edu.pe.idat.myphantomapp.retrofit.requests

import com.google.gson.annotations.SerializedName

data class RequestUser(

    @SerializedName("name"     ) var name     : String? = null,
    @SerializedName("lastname" ) var lastname : String? = null,
    @SerializedName("username" ) var username : String? = null,
    @SerializedName("email"    ) var email    : String? = null,
    @SerializedName("password" ) var password : String? = null

)