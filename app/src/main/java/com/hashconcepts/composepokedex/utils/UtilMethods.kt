package com.hashconcepts.composepokedex.utils

import android.graphics.Color
import java.util.*

/**
 * @created 23/06/2022 - 12:51 PM
 * @project ComposePokedex
 * @author  ifechukwu.udorji
 */

object UtilMethods {
    fun generateRandomColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}