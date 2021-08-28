package com.antino.labs_antino.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.opskube.myapplication.Network.RetroInstance
import com.opskube.myapplication.Network.RetroService
import com.opskube.myapplication.RecyclerList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {

    var recyclerListLiveData: MutableLiveData<RecyclerList>

    init {
        recyclerListLiveData = MutableLiveData()
    }

    fun getRecyclerListObserver():MutableLiveData<RecyclerList>{
        return recyclerListLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getDataFromApi()
            recyclerListLiveData.postValue(response)
        }
    }

}