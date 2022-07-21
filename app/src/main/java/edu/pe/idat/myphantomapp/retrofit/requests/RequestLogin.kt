package edu.pe.idat.myphantomapp.retrofit.requests

import com.google.gson.annotations.SerializedName

data class RequestLogin (

    @SerializedName("identifier" ) var identifier : String? = null,
    @SerializedName("password"   ) var password   : String? = null

)