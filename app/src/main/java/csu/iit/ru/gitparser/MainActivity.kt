package csu.iit.ru.gitparser

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request


class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        Thread(Runnable {
            val client = OkHttpClient()
            val request = Request.Builder()
                    .url("https://api.github.com/users/blueberryfox/repos")
                    .build()
            val response = client.newCall(request).execute()
            val responseText = response.body()!!.string()
            var repos = Gson().fromJson(responseText, GitHubRepositoryInfo.List::class.java)
            runOnUiThread {
                var adapter = DataAdapter(repos)
                recyclerView.adapter = adapter
            }
            android.util.Log.d("Repos", repos.joinToString { it.name })
        }).start()
    }
}
