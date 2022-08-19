package edu.pe.idat.myphantomapp.retrofit.responses

import com.google.gson.annotations.SerializedName
data class ProviderMetadata (

    @SerializedName("public_id"     ) var publicId     : String? = null,
    @SerializedName("resource_type" ) var resourceType : String? = null

)
data class AttributesPicture (

    @SerializedName("name"              ) var name             : String? = null,
    @SerializedName("alternativeText"   ) var alternativeText  : String? = null,
    @SerializedName("caption"           ) var caption          : String? = null,
    @SerializedName("width"             ) var width            : Int?    = null,
    @SerializedName("height"            ) var height           : Int?    = null,
    @SerializedName("hash"              ) var hash             : String? = null,
    @SerializedName("ext"               ) var ext              : String? = null,
    @SerializedName("mime"              ) var mime             : String? = null,
    @SerializedName("size"              ) var size             : Double? = null,
    @SerializedName("url"               ) var url              : String? = null,
    @SerializedName("previewUrl"        ) var previewUrl       : String? = null,
    @SerializedName("provider"          ) var provider         : String? = null,
    @SerializedName("provider_metadata" ) var providerMetadata : ProviderMetadata? = ProviderMetadata(),
    @SerializedName("createdAt"         ) var createdAt        : String? = null,
    @SerializedName("updatedAt"         ) var updatedAt        : String? = null

)

data class DataPicture (

    @SerializedName("id"         ) var id         : Int?        = null,
    @SerializedName("attributes" ) var attributes : AttributesPicture? = AttributesPicture()

)

data class Picture (

    @SerializedName("data" ) var data : DataPicture? = DataPicture()

)

data class Attributes (

    @SerializedName("title"       ) var title       : String?  = null,
    @SerializedName("description" ) var description : String?  = null,
    @SerializedName("price"       ) var price       : Double?  = null,
    @SerializedName("stock"       ) var stock       : Int?     = null,
    @SerializedName("createdAt"   ) var createdAt   : String?  = null,
    @SerializedName("updatedAt"   ) var updatedAt   : String?  = null,
    @SerializedName("publishedAt" ) var publishedAt : String?  = null,
    @SerializedName("picture"     ) var picture     : Picture? = Picture()

)

data class Data (

    @SerializedName("id"         ) var id         : Int?        = null,
    @SerializedName("attributes" ) var attributes : Attributes? = Attributes()

)



data class ResponseListProducts (

    @SerializedName("data" ) var data : ArrayList<Data> = arrayListOf()

)