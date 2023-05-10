package com.example.tvapp

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.VideoView
import androidx.fragment.app.FragmentActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : FragmentActivity() {

    private val baseUrl = "https://www.panarmenian.tv/wp-json/"

//    var videoUrl = "https://us1.ottstream.live:17071/C279/index.m3u8?token=123TREWQ456"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()

    }

    private fun getData() {
        val retrofitBuilder =
            Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseUrl)
                .build().create(apiInterface::class.java)


        val retrofitData = retrofitBuilder.getLinks()

        retrofitData.enqueue(object : Callback<mylink> {
            override fun onFailure(call: Call<mylink>, t: Throwable) {
                Log.e("Errrorr", "Fail" + t.message)
            }

            override fun onResponse(call: Call<mylink>, response: Response<mylink>) {


                val res = response.body()
                val userInstance = res?.android_tv_url
                Log.e("DATA", res.toString())

                val videoView = findViewById<VideoView>(R.id.simpleVideoView)
                val progress = findViewById<ProgressBar>(R.id.progressbar)

                val uri = Uri.parse(userInstance)

                videoView.setVideoURI(uri)

                videoView.setOnPreparedListener {
                    videoView.start()
                    progress.visibility = View.GONE

                }
            }
        })
    }
}