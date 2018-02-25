package itinoseapps.currentweather

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class OpenWeatherMapAPI {

    val openWeatherAPIEndPoint = "http://api.openweathermap.org/data/2.5/"

    fun getCurrentWeather(location: String,key: String):String{
        return buildRequestUrl(location,"weather", key)
    }

    private fun buildRequestUrl(location:String,urlparam:String,key:String):String{
        val builder = StringBuilder()

        val requestUrl = builder.
                append(openWeatherAPIEndPoint)
                .append(urlparam)
                .append("?q=")
                .append(location)
                .append("&appid=")
                .append(key).toString()

        return sendhttpRequest(requestUrl)
    }

    private fun sendhttpRequest(url :String):String{
        val requestUrl = URL(url)

        val connection = requestUrl.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.setRequestProperty("ContentType", "application/json")
        connection.connect()

        return handleResponse(connection)
    }

    private fun handleResponse(connection: HttpURLConnection):String{
        val isr = InputStreamReader(connection.inputStream)
        val reader = BufferedReader(isr)
        val builder = StringBuilder()
        val line=reader.readLine()

        System.out.println(builder.append(line))

        reader.close()

        return builder.toString()
    }
}