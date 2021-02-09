package my.test.twich.Retrofit


import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import my.test.twich.Interface.RetrofitTwichServices
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//const val API_KEY="v13jf6umknvj4dtvmd7kbvjwnw9twe"
//const val SECRET="4owd6ch3ogrgdgn49kz1afstpfpzga"

//ApiFactory to create Twich Api
object Apifactory{
    //Creating Auth Interceptor to add Client-ID in front of all the requests.
    private val authInterceptor = Interceptor {chain->
        /*val newUrl = chain.request().url()
            .newBuilder()
            /*.addQueryParameter("client_id", API_KEY)
            .addQueryParameter("client_secret", SECRET)*/
            .build()*/

        val newRequest = chain.request()
            .newBuilder()
            .addHeader("Accept", "application/vnd.twitchtv.v5+json")
            .addHeader("Client-ID", "v13jf6umknvj4dtvmd7kbvjwnw9twe")
            /*.url(newUrl)*/
            .build()

        chain.proceed(newRequest)
    }

    //OkhttpClient for building http request url
    private val twichClient = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .build()

    fun retrofit() : Retrofit = Retrofit.Builder()
        .client(twichClient)
        .baseUrl("https://api.twitch.tv/kraken/games/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val retrofitTwichServices : RetrofitTwichServices = retrofit().create(RetrofitTwichServices::class.java)
}
