package my.test.twich.Model


import com.google.gson.annotations.SerializedName

data class Game(
    @SerializedName("_total")
    val total: Int?,
    val top: List<Top>
)