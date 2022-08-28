package com.example.androidbasic.extension

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import androidx.annotation.LayoutRes
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

fun ViewGroup.inflateBind(@LayoutRes layoutRes: Int, attachToParent: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToParent)
}

fun EditText.changedFlow(): Flow<String> {
    return callbackFlow {
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                trySendBlocking(text?.toString().orEmpty())
            }

            override fun afterTextChanged(p0: Editable?) {}
        }

        this@changedFlow.addTextChangedListener(textWatcher)

        awaitClose {
            this@changedFlow.removeTextChangedListener(textWatcher)
        }
    }
}

fun CheckBox.checkedChangesFlow(): Flow<Boolean> {
    return callbackFlow {
        val listener = CompoundButton.OnCheckedChangeListener { _, isChecked ->
            trySendBlocking(isChecked)
        }
        this@checkedChangesFlow.setOnCheckedChangeListener(listener)
        awaitClose {
            this@checkedChangesFlow.setOnCheckedChangeListener(null)
        }
    }
}