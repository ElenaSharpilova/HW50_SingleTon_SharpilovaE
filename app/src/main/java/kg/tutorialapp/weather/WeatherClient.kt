package kg.tutorialapp.weather

import kg.tutorialapp.weather.network.PostsApi
import kg.tutorialapp.weather.network.WeatherApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherClient {

    private val okhhtp by lazy {
        val interceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        OkHttpClient.Builder().addInterceptor(interceptor).build()
    }


    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhhtp)
            .build()
    }

    val weatherApi by lazy {
        retrofit.create(WeatherApi::class.java)
    }

}