package my.test.twich.Model


import com.google.gson.annotations.SerializedName

data class GameX(
    val name: String?,
    @SerializedName("_id")
    val id: Int?,
    @SerializedName("giantbomb_id")
    val giantbombId: Int?,
    val box: Box,
    val logo: Logo,
    @SerializedName("localized_name")
    val localizedName: String?,
    val locale: String?
)