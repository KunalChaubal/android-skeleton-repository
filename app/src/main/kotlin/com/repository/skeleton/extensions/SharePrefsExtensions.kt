@file:JvmName("SharedPrefsUtils")

package com.repository.skeleton.extensions

import android.content.SharedPreferences

/**
 *  Extension method to remove boilerplate code to save to [SharedPreferences]
 */
inline fun SharedPreferences.edit(body: SharedPreferences.Editor.() -> Unit) {
    val editor: SharedPreferences.Editor = edit()
    editor.body()
    editor.apply()
}

/**
 *  Helper method to put a [String, String] to [SharedPreferences]
 */
fun SharedPreferences.Editor.pair(pair: Pair<String, String>) = putString(pair.first, pair.second)

fun SharedPreferences.clear() {
    edit().clear().apply()
}