package my.test.twich.app03_data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
//import my.test.twich.app01_view.db

//import my.test.twich.app03_data.db.GameDao
import my.test.twich.app03_data.model.Game
import my.test.twich.app03_data.net.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GameRepositoryImpl : GameRepository {

    //private val gameDao: GameDao = db.gameDao()
    private val retrofitClient = RetrofitClient
    //private val allGames: LiveData<Game?>

    init {
        //gameDao.setAll(updateGames().value)
        //allGames = gameDao.getAll()
    }



    //override fun getSavedGames() = allGames

    override fun updateGames(): LiveData<Game?> {
        val data = MutableLiveData<Game>()
        retrofitClient.GAME_API.getGame().enqueue(object : Callback<Game> {
            override fun onFailure(call: Call<Game>, t: Throwable) {
                data.value = null
            }
            override fun onResponse(call: Call<Game>, response: Response<Game>) {
                data.value = response.body()
                //gameDao.save(response.body())
            }
        })
        return data
    }
}