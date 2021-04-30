package my.test.twitch.app03_data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import my.test.twitch.app03_data.model.Top


@Dao
interface GameDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(top:List<Top>)
    @Query("select * from top")
    fun load(): /*LiveData<List<Top>>*/Flow<List<Top>>

}