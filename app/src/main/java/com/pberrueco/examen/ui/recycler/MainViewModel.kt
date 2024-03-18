package com.pberrueco.examen.ui.recycler

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pberrueco.examen.data.data_store.DataStoreManager
import com.pberrueco.examen.data.network.TaskApi
import com.pberrueco.examen.data.network.model.TaskResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var _userName: MutableLiveData<String?> = MutableLiveData(null)
    val userName: LiveData<String?> = _userName

    private val _homeWorkResponse = MutableLiveData<List<TaskResponse>>()
    val homeWorkResponse: LiveData<List<TaskResponse>> = _homeWorkResponse

    fun getUserName(context: Context) {
        viewModelScope.launch(Dispatchers.IO){
            DataStoreManager.getData(context).collect{ userName ->
                if(userName != "No Data"){
                    _userName.postValue(userName)
                }
            }
        }

    }

    fun getTask(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = TaskApi.service.getHomeWork(userName, "departament1")
                if (response.isSuccessful) {
                    val homeWorkList = response.body()
                    _homeWorkResponse.postValue(homeWorkList!!)
                } else {
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}