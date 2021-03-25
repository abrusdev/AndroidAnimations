package ru.abrus.androidanimations.ui.choreographing

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
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

        viewPropertyAnimator.setOnClickListener {
            createViewPropertyAnimator()
        }

        propertyValuesHolder.setOnClickListener {
            createPropertyValuesHolder()
        }
    }

    private fun createPropertyValuesHolder() {
        val scaX = PropertyValuesHolder.ofFloat("scaleX", 1.4f)
        val scaY = PropertyValuesHolder.ofFloat("scaleY", 1.4f)
        val rotX = PropertyValuesHolder.ofFloat("rotationX", 360f)
        val transY = PropertyValuesHolder.ofFloat("translationY", -300f)

        ObjectAnimator.ofPropertyValuesHolder(coinImage, scaX, scaY, rotX, transY).apply {
            duration = 1000
            interpolator = AccelerateInterpolator()
            start()
        }
        Handler(Looper.getMainLooper()).postDelayed({
            restartTarget()
        },1000)
    }

    private fun createViewPropertyAnimator() {
        coinImage.animate().apply {
            duration = 1000
            scaleX(1.4f)
            scaleY(1.4f)
            rotationX(360f)
            translationY(-300f)

            interpolator = AccelerateDecelerateInterpolator()
            start()
        }
        Handler(Looper.getMainLooper()).postDelayed({
            restartTarget()
        },1000)
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

    private fun restartTarget() {
        coinImage.animate().scaleX(1f).scaleY(1f).translationY(0f).rotationX(0f).duration = 1000
    }
}