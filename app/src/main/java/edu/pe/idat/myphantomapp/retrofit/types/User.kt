package edu.pe.idat.myphantomapp.retrofit.types

import com.google.gson.annotations.SerializedName

data class User (

    @SerializedName("id"        ) var id        : Int?     = null,
    @SerializedName("username"  ) var username  : String?  = null,
    @SerializedName("email"     ) var email     : String?  = null,
    @SerializedName("provider"  ) var provider  : String?  = null,
    @SerializedName("confirmed" ) var confirmed : Boolean? = null,
    @SerializedName("blocked"   ) var blocked   : Boolean? = null,
    @SerializedName("createdAt" ) var createdAt : String?  = null,
    @SerializedName("updatedAt" ) var updatedAt : String?  = null,
    @SerializedName("address"   ) var address   : String?  = null,
    @SerializedName("name"      ) var name      : String?  = null,
    @SerializedName("lastname"  ) var lastname  : String?  = null

)