package com.example.androidbasic.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflateBind(@LayoutRes layoutRes: Int, attachToParent: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToParent)
}