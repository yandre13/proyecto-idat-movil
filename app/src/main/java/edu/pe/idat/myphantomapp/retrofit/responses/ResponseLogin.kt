package edu.pe.idat.myphantomapp.retrofit.responses

import com.google.gson.annotations.SerializedName
import edu.pe.idat.myphantomapp.retrofit.types.User

data class ResponseLogin (

    @SerializedName("jwt"  ) var jwt  : String? = null,
    @SerializedName("user" ) var user : User?   = User()

)