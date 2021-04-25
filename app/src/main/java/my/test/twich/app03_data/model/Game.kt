package my.test.twich.app03_data.model


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.google.gson.annotations.SerializedName

@Entity
data class Game(

    @SerializedName("_total")
    val total: Int?,
    @Relation(parentColumn = "total",entityColumn = "game")

    val top: List<Top>
)