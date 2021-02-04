package my.test.twich.Retrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import my.test.twich.Interface.RetrofitTwichServices
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//const val API_KEY="sd4grh0omdj9a31exnpikhrmsu3v46"
//const val API_KEY="v13jf6umknvj4dtvmd7kbvjwnw9twe"
//ApiFactory to create Twich Api
object Apifactory{
    //Creating Auth Interceptor to add api_key query in front of all the requests.
    private val authInterceptor = Interceptor {chain->
        val newUrl = chain.request().url()
            .newBuilder()
            /*.addQueryParameter("api_key", API_KEY)*/
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    //OkhttpClient for building http request url
    private val twichClient = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .build()

    fun retrofit() : Retrofit = Retrofit.Builder()
        .client(twichClient)
        .baseUrl("https://www.simplifiedcoding.net/demos/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val retrofitTwichServices : RetrofitTwichServices = retrofit().create(RetrofitTwichServices::class.java)
}
