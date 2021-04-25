package my.test.twich.app02_viewModel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import my.test.twich.app03_data.GameRepository
import my.test.twich.app03_data.GameRepositoryImpl
import my.test.twich.app03_data.model.Game

class GamesViewModel(private val repository:GameRepository=GameRepositoryImpl()):ViewModel() {
    private val allGames = MediatorLiveData<Game>()

    init {
        getAllGames()
    }

    fun getGames() = allGames

    private fun getAllGames() {
        allGames.addSource(repository.updateGames()) { games ->
            allGames.postValue(games)
        }
    }
}