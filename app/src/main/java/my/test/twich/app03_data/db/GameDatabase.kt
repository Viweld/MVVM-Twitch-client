package my.test.twich.app03_data.db

/*import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import my.test.twich.app01_view.MainActivity
import my.test.twich.app03_data.model.Game

@Database(entities = [Game::class], version = 1)

abstract class GameDatabase: RoomDatabase() {
    abstract fun gameDao(): GameDao

    companion object {
        private val lock = Any()
        private const val DB_NAME = "GameDatabase"
        private var INSTANCE: GameDatabase? = null


        fun getInstance(activity: MainActivity): GameDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE =
                        Room.databaseBuilder(activity, GameDatabase::class.java, DB_NAME)
                            .build()
                }
            }
            return INSTANCE!!
        }
    }
}*/