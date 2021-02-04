package my.test.twich.Interface

import my.test.twich.Model.Movie

import retrofit2.Call
import retrofit2.http.*



interface RetrofitTwichServices {
    @GET("marvel")
    fun getGame(): Call<MutableList<Movie>>


}