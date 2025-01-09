package com.smartherd.namenewproject.ViewModels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smartherd.namenewproject.data.API_KEY
import com.smartherd.namenewproject.data.CONTENT_TYPE
import com.smartherd.namenewproject.data.models.MovesModel
import com.smartherd.namenewproject.data.response.MovesResponse
import com.smartherd.namenewproject.data.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllMovesViewModel : ViewModel(){

    private var moveis: MutableLiveData<List<MovesModel>> = MutableLiveData<List<MovesModel>>()


    init {
        getMoves()
    }

    private fun getMoves(){
        RetrofitInstance.movesApi.getAllMoves(CONTENT_TYPE, API_KEY).enqueue(object : Callback<MovesResponse> {
            override fun onResponse(call: Call<MovesResponse>, response: Response<MovesResponse>) {
                moveis.value = response.body()!!.allmoves
            }

            override fun onFailure(call: Call<MovesResponse>, t: Throwable) {
                Log.d(TAG,t.message.toString())
            }

        })
    }

    fun observeCategories(): LiveData<List<MovesModel>> {
        return moveis
    }
}