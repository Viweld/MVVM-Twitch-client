package my.test.twich.Interface

import my.test.twich.Model.Game
import my.test.twich.Model.GameX
import retrofit2.Call
import retrofit2.http.*



interface RetrofitTwichServices {
    @GET("top")
    fun getGame(): Call<Game>


}