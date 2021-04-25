package my.test.twich.app03_data

import androidx.lifecycle.LiveData
import my.test.twich.app03_data.model.Game

interface GameRepository {
    //fun getSavedGames(): LiveData<Game?>
    fun updateGames(): LiveData<Game?>


}