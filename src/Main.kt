import itinoseapps.currentweather.OpenWeatherMapAPI

fun main(args:Array<String>){
    val weather = OpenWeatherMapAPI()
    weather.getCurrentWeather("Tokyo","YOUR API KEY")
}
