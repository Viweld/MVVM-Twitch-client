package my.test.twich.app03_data

import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import my.test.twich.app03_data.db.GameDao
import my.test.twich.app03_data.model.Game
import my.test.twich.app03_data.model.Top
import my.test.twich.app03_data.net.GameAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val gameDao: GameDao,
    private val gameAPI: GameAPI
) {

    fun getSavedGames(): /*LiveData<List<Top>>*/Flow<List<Top>> {
        downloadAndSaveGames()
        return gameDao.load()
    }

    fun downloadAndSaveGames() {
        gameAPI.getGame().enqueue(object : Callback<Game> {
            override fun onFailure(call: Call<Game>, t: Throwable) {
            }

            override fun onResponse(call: Call<Game>, response: Response<Game>) {
                gameDao.save(response.body()!!.top)
                Log.d("TESTDATA_REPO", response.body()!!.total.toString())
            }
        })
    }
}