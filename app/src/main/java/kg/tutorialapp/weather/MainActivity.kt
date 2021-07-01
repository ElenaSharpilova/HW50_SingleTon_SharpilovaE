package kg.tutorialapp.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kg.tutorialapp.weather.models.ForeCast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var textView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fetchWeatherUsingQuerry()
    }

    private fun fetchWeatherUsingQuerry() {
        val call = WeatherClient.weatherApi.fetWeatherUsingQuerry(lat = 40.513996, lon = 72.816101, lang = "en")

        call.enqueue(object : Callback<ForeCast> {
            override fun onFailure(call: Call<ForeCast>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<ForeCast>, response: Response<ForeCast>) {
                if (response.isSuccessful) {
                    val foreCast = response.body()
                    foreCast?.let {
                        textView = findViewById(R.id.textView)
                        textView2 = findViewById(R.id.textView2)
                        textView.text = it.current?.weather!![0].description
                        textView2.text = it.current?.temp?.toString()

                    }
                }
            }

        })

    }
}
