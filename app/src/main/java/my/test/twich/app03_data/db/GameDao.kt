package my.test.twich.app03_data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import my.test.twich.app03_data.model.Game


@Dao
interface GameDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(games:Game?)
    @Query("select * from game")
    fun load():LiveData<Game?>

}