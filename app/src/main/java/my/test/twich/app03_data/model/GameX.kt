package my.test.twich.app03_data.model


import androidx.room.Embedded
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class GameX(
    val name: String?,
    @PrimaryKey
    @SerializedName("_id")
    val id: Int?,
    @SerializedName("giantbomb_id")
    val giantbombId: Int?,
    @Embedded
    val box: Box,
    @Embedded
    val logo: Logo,
    @SerializedName("localized_name")
    val localizedName: String?,
    val locale: String?
)