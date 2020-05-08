package com.repository.skeleton.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 *  Helper method to inflate a layout in [ViewGroup]
 *
 *  @param layoutId Layout Id to inflate
 */
fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}

/**
 *  Helper method to set visibility of a [View]
 */
fun View.show() {
    visibility = View.VISIBLE
}

/**
 *  Helper method to set invisibility of a [View]
 */
fun View.invisible() {
    visibility = View.INVISIBLE
}

/**
 *  Helper method to hide a [View]
 */
fun View.hide() {
    visibility = View.GONE
}

/**
 * Helper method to test for visibility
 */
fun ViewGroup.isVisible() = visibility == View.VISIBLE

/**
 *  Helper method to get a child view by position
 *
 *  @param position Child view position
 */
fun ViewGroup.get(position: Int): View? {
    return getChildAt(position)
}

/**
 * Helper method toggle [View] visibility
 */
fun View.toggleVisibility() {
    when (visibility) {
        View.VISIBLE -> {
            hide()
        }
        View.GONE -> {
            show()
        }
    }
}