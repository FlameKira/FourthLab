package com.example.internettest

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnHTTP = findViewById<Button>(R.id.btnHTTP)

        val url = URL(
            "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aa\n" +
                    "fb6ea3de826464&tags=cat&format=json&nojsoncallback=1"
        )

        btnHTTP.setOnClickListener {
            Thread(Runnable {
                val con = url.openConnection() as HttpURLConnection
                val data = con.inputStream.bufferedReader().readText()
                Log.d("Flickr cats", data)
            }).start()
        }

        val btnOkHTTP = findViewById<Button>(R.id.btnOkHTTP)


        val client: OkHttpClient = OkHttpClient();
        btnOkHTTP.setOnClickListener {
            Thread(Runnable {
                val request = Request.Builder().url(url).build()
                val response = client.newCall(request).execute()
                try {
                    val data = response.body?.string()
                    if (data != null) {
                        Log.i("Flickr OkCats", data)
                    }
                } catch (err: Error) {
                    Log.d("Error", err.localizedMessage)
                }
            }).start()
        }
    }
}