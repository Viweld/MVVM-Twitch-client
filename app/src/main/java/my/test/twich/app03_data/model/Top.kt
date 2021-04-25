package my.test.twich.app03_data.model

import androidx.room.Embedded
import androidx.room.Entity


@Entity
data class Top(
    @Embedded
    val game: GameX,
    val viewers: Int?,
    val channels: Int?
)