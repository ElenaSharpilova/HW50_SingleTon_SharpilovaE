package kg.tutorialapp.weather.models

import com.google.gson.annotations.SerializedName

data class ForeCast(
        var lot : Double? = null,
        var lon : Double? = null,
        var timezone: String? = null,
        var timezone_offset: Long? = 0,
        var current: CurrentForeCast? = null,
        var hourly: List<HourlyForeCast>? = null,
        var daily: List<DailyForeCast>
)

data class CurrentForeCast(
        @SerializedName("dt")
        var date: Long? = null,
        var sunrise: Long? = null,
        var sunset: Long? = null,
        var temp: Double? = null,
        var feels_like: Double? = null,
        var humidity: Int? = null,
        var weather: List<Weather>
)

data class Weather(
        var id : Long? = null,
        var description: String? = null,
        var icon: String? = null
)

data class HourlyForeCast(
        @SerializedName("dt")
        var date: Long? = null,
        var temp: Double? = null,
        var weather: List<Weather>,
        @SerializedName("pop")
        var probability: Double? = null
)

data class DailyForeCast(
        @SerializedName("dt")
        var date: Long? = null,
        var temp: Temperature? = null,
        var weather: List<Weather>? = null,
        @SerializedName("pop")
        var probability: Double? = null
)

data class Temperature(
        var max: Double? = null,
        var min: Double? = null
)
