package jp.dorakura.myapplication.ui.motivation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MotivationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "I like cakes"
    }
    val text: LiveData<String> = _text
}