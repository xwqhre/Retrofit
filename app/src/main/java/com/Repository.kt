package com

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.remote.LoveModel
import com.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getLoveMutableLiveData(firsName: String, secondName:String):
            MutableLiveData<LoveModel>{

        val liveData = MutableLiveData<LoveModel>()
        RetrofitService().api.getPercentage(firsName, secondName)
            .enqueue(object : Callback<LoveModel>{
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    liveData.postValue(response.body())
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message}", )
                }
            })

        return liveData
    }
}