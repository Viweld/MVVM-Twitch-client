package my.test.twitch.app02_viewModel

import android.util.Log
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import my.test.twitch.app03_data.GameRepositoryImpl
import my.test.twitch.app03_data.model.Top
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    private val repository: GameRepositoryImpl
) : ViewModel() {

    /*var allGames:LiveData<List<Top>>?=null
    init{
        allGames=repository.gameDao.load()
    }

    fun getGames()=repository.getSavedGames()*/

    private val allGames = MediatorLiveData<List<Top>>()

    init {
        getAllGames()
    }

    fun getGames() = allGames

    private fun getAllGames() {
        //viewModelScope.launch {
            allGames.addSource(repository.getSavedGames().asLiveData()) { games ->
                allGames.postValue(games)
                //Log.d("TESTDATA-VM",games[5].game.name)
            }
        //}

    }


    //val top = repository.getSavedGames().asLiveData()
}