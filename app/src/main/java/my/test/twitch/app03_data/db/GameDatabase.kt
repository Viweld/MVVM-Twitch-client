package my.test.twitch.app03_data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import my.test.twitch.app01_view.MainActivity
import my.test.twitch.app03_data.model.Game
import my.test.twitch.app03_data.model.Top

@Database(entities = [Top::class], version = 1)
abstract class GameDatabase: RoomDatabase() {
    abstract fun gameDao(): GameDao
}