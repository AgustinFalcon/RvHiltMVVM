package com.example.rvhiltretrofitmvvmagus.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rvhiltretrofitmvvmagus.models.TvShowItem
import com.example.rvhiltretrofitmvvmagus.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TvShowViewModel
@Inject
constructor(private val repository: TvShowRepository) : ViewModel(){


    private val _repository = MutableLiveData<List<TvShowItem>>()
    val responseTvShow : MutableLiveData<List<TvShowItem>>
         get() = _repository

    init {
        getAllTvShow()
    }



    private fun getAllTvShow() {
        viewModelScope.launch {
            repository.getTvShow().let { response ->
                if (response.isSuccessful){
                    _repository.postValue(response.body())
                } else {
                    Log.d(TAG,"Error: ${response.code()}")
                    Log.d(TAG,"Error2: ${response.errorBody()}")
                }

            }
        }
    }


    companion object{
        const val TAG = "TvShowViewModel"
    }
}