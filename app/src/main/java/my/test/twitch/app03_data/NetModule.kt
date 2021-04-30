package my.test.twitch.app03_data
import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import my.test.twitch.app03_data.model.Game
import my.test.twitch.app03_data.net.GameAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


const val ACCEPT="application/vnd.twitchtv.v5+json"
const val API_KEY="v13jf6umknvj4dtvmd7kbvjwnw9twe"
const val BASE_URL="https://api.twitch.tv/kraken/games/"

@InstallIn(SingletonComponent::class)
@Module
class NetModule {

    @Provides
    @Singleton
    fun providesGamesEndpoints() : GameAPI {
        Log.d("TESTDATA","providesGamesEndpoints сработала")
        val authInterceptor = Interceptor { chain ->
            val newRequest = chain.request()
                .newBuilder()
                .addHeader("Accept", ACCEPT)
                .addHeader("Client-ID", API_KEY)
                .build()
            chain.proceed(newRequest)
        }

        val okHttpClient=OkHttpClient().newBuilder()
            .addInterceptor(authInterceptor)
            .build()

        val retrofit=Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(GameAPI::class.java)
    }
}