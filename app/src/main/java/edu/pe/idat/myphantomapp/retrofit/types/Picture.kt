package edu.pe.idat.myphantomapp.retrofit.types

import com.google.gson.annotations.SerializedName

data class Picture (

    @SerializedName("id"                ) var id               : Int?     = null,
    @SerializedName("name"              ) var name             : String?  = null,
    @SerializedName("alternativeText"   ) var alternativeText  : String?  = null,
    @SerializedName("caption"           ) var caption          : String?  = null,
    @SerializedName("width"             ) var width            : Int?     = null,
    @SerializedName("height"            ) var height           : Int?     = null,
    @SerializedName("hash"              ) var hash             : String?  = null,
    @SerializedName("ext"               ) var ext              : String?  = null,
    @SerializedName("mime"              ) var mime             : String?  = null,
    @SerializedName("size"              ) var size             : Double?  = null,
    @SerializedName("url"               ) var url              : String?  = null,
    @SerializedName("previewUrl"        ) var previewUrl       : String?  = null,
    @SerializedName("provider"          ) var provider         : String?  = null,
    @SerializedName("provider_metadata" ) var providerMetadata : String?  = null,
    @SerializedName("createdAt"         ) var createdAt        : String?  = null,
    @SerializedName("updatedAt"         ) var updatedAt        : String?  = null

)