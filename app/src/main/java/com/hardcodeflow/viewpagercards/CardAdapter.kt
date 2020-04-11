package com.hardcodeflow.viewpagercards

import androidx.cardview.widget.CardView

interface CardAdapter {
    val baseElevation: Float

    fun getCardViewAt(position: Int): CardView?
    val number: Int

    companion object {
        const val MAX_ELEVATION_FACTOR = 8
    }
}
