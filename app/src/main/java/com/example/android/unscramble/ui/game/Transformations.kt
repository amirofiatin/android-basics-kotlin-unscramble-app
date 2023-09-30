package com.example.android.unscramble.ui.game

import android.text.Spannable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Transformations {
    companion object {
        fun map(
            _currentScrambledWord: MutableLiveData<String>,
            function: () -> Spannable
        ): LiveData<Spannable> {
            TODO("Not yet implemented")
        }
    }

}
