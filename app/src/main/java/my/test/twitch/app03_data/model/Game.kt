package my.test.twitch.app03_data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.google.gson.annotations.SerializedName

data class Game(
    @SerializedName("_total")
    val total: Int,
    val top: List<Top>
)