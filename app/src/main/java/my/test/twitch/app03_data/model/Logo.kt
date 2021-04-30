package my.test.twitch.app03_data.model

import androidx.room.Entity


data class Logo(
    val large: String,
    val medium: String,
    val small: String,
    val template: String
)