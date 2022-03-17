package com.example.retrofitforecaster

import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private var adapter = Adapter().apply {
        setAdapter()
    }

    fun getAdapter(): Adapter {
        return adapter
    }

    private fun setAdapter() {
        val mService = Common.retrofitService
        mService.getWeatherList().enqueue(object : Callback<DataWeather> {
            override fun onResponse(call: Call<DataWeather>, response: Response<DataWeather>) {
                val dataWeather = response.body() as DataWeather
                adapter.submitList(dataWeather.list)
            }
            override fun onFailure(call: Call<DataWeather>, t: Throwable) {
            }
        })
    }
}