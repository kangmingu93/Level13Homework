package com.crayon.level13homework.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.crayon.level13homework.models.Photo
import com.crayon.level13homework.repository.PhotoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PhotoViewModel(private val repository: PhotoRepository): ViewModel() {

    private val _photoList : MutableLiveData<Photo> = MutableLiveData()
    val photoList: LiveData<Photo>
        get() = _photoList


    fun list() {
        CoroutineScope(Dispatchers.IO).launch {
            val result = repository.requestPhotoList()
            _photoList.postValue(result)
        }
    }

}