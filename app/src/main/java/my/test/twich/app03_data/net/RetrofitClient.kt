package my.test.twich.app03_data.net


import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val ACCEPT="application/vnd.twitchtv.v5+json"
const val API_KEY="v13jf6umknvj4dtvmd7kbvjwnw9twe"
const val BASE_URL="https://api.twitch.tv/kraken/games/"


//ApiFactory to create Twich Api
object RetrofitClient {
    //Creating Auth Interceptor to add Client-ID in front of all the requests.
    private val authInterceptor = Interceptor {chain->
        val newRequest = chain.request()
            .newBuilder()
            .addHeader("Accept", ACCEPT)
            .addHeader("Client-ID", API_KEY)
            .build()

        chain.proceed(newRequest)
    }

    //OkhttpClient for building http request url
    private val twichClient = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .build()

    fun retrofit() : Retrofit = Retrofit.Builder()
        .client(twichClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val GAME_API : GameAPI = retrofit().create(GameAPI::class.java)

}
