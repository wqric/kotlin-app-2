package com.example.task

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.noRippleClickable(onClick: () -> Unit) = composed {
    Modifier.clickable(remember { MutableInteractionSource() }, null) {
        onClick.invoke()
    }
}

fun String.addCharAtIndex(char: Char, index: Int): String {
    return if (index < this.length){
        StringBuilder(this).apply { insert(index, char) }.toString()
    } else{
        this + char
    }
}

fun String.deleteCharAtIndex(index: Int): String = StringBuilder(this).apply { deleteAt(index) }.toString()