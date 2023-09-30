package com.example.android.unscramble.ui.game

import android.text.Spannable
import android.text.SpannableString
import android.text.style.TtsSpan
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


private var Nothing?.value: Any
    get() {}


private fun Any.onCleared() {
    TODO("Not yet implemented")
}

/**
 * ViewModel containing the app data and methods to process the data
 */
class GameViewModel {
    private val _score = MutableLiveData(0)
    val score: LiveData<Int>
        get() = _score

    private val _currentWordCount = MutableLiveData(0)
    val currentWordCount: LiveData<Int>
        get() = _currentWordCount

    private val _currentScrambledWord = MutableLiveData<String>()
    val currentScrambledWord: LiveData<Spannable> = Transformations.map(_currentScrambledWord) {
        val it = null
        if (it == null) {
            SpannableString("")
        } else {
            val it = null
            val scrambledWord = it.toString()
            val spannable: Spannable = SpannableString(scrambledWord)
            spannable.setSpan(
                TtsSpan.VerbatimBuilder(scrambledWord).build(),
                0,
                scrambledWord.length,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )
            spannable
        }
    }

    // List of words used in the game
    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    init {
        Log.d("GameFragment", "GameViewModel created!")
        getNextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
        }
    /*
    * Updates currentWord and currentScrambledWord with the next word.
    */
    private fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()

        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }
        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord.value = String(tempWord)
            _currentWordCount.value = (_currentWordCount.value)?.inc()
            wordsList.add(currentWord)
        }
    }

    /*
        * Re-initializes the game data to restart the game.
        */
        fun reinitializeData() {
            _score.value = 0
            _currentWordCount.value = 0
            wordsList.clear()
            getNextWord()
        }

    fun isUserWordCorrect(playerWord: String): Boolean {

    }
}
        /*
       * Increases the game score if the player's word is correct.
       */
        private fun increaseScore() {
            val _score = null
            _score.value = (_score.value)?.plus(SCORE_INCREASE)
        }

private fun Any.plus(scoreIncrease: Int): Any {
    TODO("Not yet implemented")
}

fun isUserWordCorrect(playerWord: String): Boolean {
        if (playerWord.equals(currentWord, true)) {
            increaseScore()
            return true
        }
        return false
    }


/*
* Returns true if the current word count is less than MAX_NO_OF_WORDS.
* Updates the next word.
*/
fun nextWord(): Boolean {
    val _currentWordCount = null
    return if (_currentWordCount.value!! < MAX_NO_OF_WORDS) {
        getNextWord()
        true
    } else false
}

fun getNextWord() {
    TODO("Not yet implemented")
}

fun String.isUserWordCorrect(): Boolean {

    }

    fun reinitializeData() {
        TODO("Not yet implemented")
    }