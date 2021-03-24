package ru.abrus.androidanimations.data

import android.content.Intent
import androidx.annotation.DrawableRes
import ru.abrus.androidanimations.R

data class MainData(
    val text: String,
    val cls: Class<*>,
    @DrawableRes val image: Int = R.drawable.image_anim
)