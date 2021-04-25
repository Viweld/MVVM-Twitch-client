package my.test.twich.app03_data.net

import my.test.twich.app03_data.model.Game
import retrofit2.Call
import retrofit2.http.*



interface GameAPI {
    @GET("top")
    fun getGame(): Call<Game>
}