package com.ptit.retrofit_example.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ptit.retrofit_example.GetDataService
import com.ptit.retrofit_example.ui.adapter.PhotoAdapter
import com.ptit.retrofit_example.R
import com.ptit.retrofit_example.model.Photo
import com.ptit.retrofit_example.model.RetrofitClientInstance
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val photoAdapter =
        PhotoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRetrofit()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerPhoto.adapter = photoAdapter
    }

    private fun initRetrofit() {
        val service: GetDataService = RetrofitClientInstance.getInstance()
            .create(GetDataService::class.java)
        val call = service.getAllPhotos()
        call.enqueue(object: Callback<List<Photo>>{

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                Log.d("TAG", "Error: ${t.message.toString()}")
            }

            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                generateData(response.body())
            }
        })
    }

    private fun generateData(body: List<Photo>?) {
        body?.let { photoAdapter.updateData(it) }
    }
}
