package com.example.lab12play.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab12play.util.Constants.Companion.DEAFULT_MESSAGE_HOME_VIEWMODEL
import com.example.lab12play.util.Constants.Companion.EMPTY_MESSAGE_HOME_VIEWMODEL
import com.example.lab12play.util.Constants.Companion.FAILURE_MESSAGE_HOME_VIEWMODEL
import com.example.lab12play.util.Constants.Companion.SUCCES_MESSAGE_HOME_VIEWMODEL
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel(){

    private val _status = MutableStateFlow<Status>(Status.default(DEAFULT_MESSAGE_HOME_VIEWMODEL))
    val status : StateFlow<Status> = _status

    private val _progessBar = MutableStateFlow<Boolean>(false)
    val progressBar : StateFlow<Boolean> = _progessBar

    sealed class Status{

        class default(val message: String): Status()
        class succes(val message: String): Status()
        class failure(val message: String): Status()
        class empty(val message: String): Status()

    }

    fun progressBar(){
        viewModelScope.launch {
            _progessBar.value = true
            delay(2000L)
            _progessBar.value = false
        }
    }

    fun Default(){
        progressBar()
        _status.value = Status.default(DEAFULT_MESSAGE_HOME_VIEWMODEL)
    }

    fun Succes(){
        progressBar()
        _status.value = Status.succes(SUCCES_MESSAGE_HOME_VIEWMODEL)
    }

    fun Failure(){
        progressBar()
        _status.value = Status.failure(FAILURE_MESSAGE_HOME_VIEWMODEL)
    }

    fun Empty(){
        progressBar()
        _status.value = Status.empty(EMPTY_MESSAGE_HOME_VIEWMODEL)
    }

}