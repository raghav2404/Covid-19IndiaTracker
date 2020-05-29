package android.example.covid_19indiatracker

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request


//singleton class to request json data from URL
object Client
{
private val okHttpClient=OkHttpClient()
    private val request=Request.Builder().url("https://api.covid19india.org/data.json").build()


    val api= okHttpClient.newCall(request)

}



