package my.test.twich.Model


import com.google.gson.annotations.SerializedName

data class Top(
    val game: GameX,
    val viewers: Int?,
    val channels: Int?
)