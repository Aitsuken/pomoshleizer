package jp.dorakura.myapplication.ui.focus

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FocusViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Pomodoro Focus"
    }
    val text: LiveData<String> = _text
}