package my.test.twitch.app03_data.model


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class GameX(
    val name: String,
    @SerializedName("_id")
    val id: Int,
    @SerializedName("giantbomb_id")
    val giantbombId: Int,
    @Embedded(prefix = "box")
    val box: Box,
    @Embedded(prefix = "logo")
    val logo: Logo,
    @SerializedName("localized_name")
    val localizedName: String,
    val locale: String
)