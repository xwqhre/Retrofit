package com

import androidx.lifecycle.LiveData
import com.remote.LoveModel

class ViewModel{ //:ViewModel()

    private val repository = Repository()

    fun getLiveLove(firstName: String, secondName: String):LiveData<LoveModel>{
         return repository.getLoveMutableLiveData(firstName, secondName)
    }
}