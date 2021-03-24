package ru.abrus.androidanimations.ui.choreographing

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choreographing_anim.*
import ru.abrus.androidanimations.R

class ChoreographingAnimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choreographing_anim)

        setFromXml.setOnClickListener {
            AnimatorInflater.loadAnimator(this, R.animator.animator_coin).apply {
                setTarget(coinImage)
                start()
            }
        }

        setFromCode.setOnClickListener {
            createAnimatorAndStart()
        }
    }

    private fun createAnimatorAndStart() {
        val root = AnimatorSet()

        val childFirst = AnimatorSet()
        val childSecond = AnimatorSet()

        root.playSequentially(childFirst, childSecond)

        childFirst.playTogether(
            ObjectAnimator.ofFloat(coinImage, "translationY", 0f, -500f).setDuration(500),
            ObjectAnimator.ofFloat(coinImage, "rotationX", 0f, 360f).setDuration(500),
            ObjectAnimator.ofFloat(coinImage, "scaleX", 1f, 1.6f).setDuration(500),
            ObjectAnimator.ofFloat(coinImage, "scaleY", 1f, 1.6f).setDuration(500)
        )

        childSecond.playTogether(
            ObjectAnimator.ofFloat(coinImage, "translationY", -500f, 0f).setDuration(1000),
            ObjectAnimator.ofFloat(coinImage, "rotationX", 0f, 720f).setDuration(1000),
            ObjectAnimator.ofFloat(coinImage, "scaleX", 1.6f, 1f).setDuration(500),
            ObjectAnimator.ofFloat(coinImage, "scaleY", 1.6f, 1f).setDuration(500)
        )

        root.start()

    }
}