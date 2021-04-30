package my.test.twich.app03_data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Top(
    @Embedded
    @PrimaryKey
    val game: GameX,
    val viewers: Int,
    val channels: Int
)