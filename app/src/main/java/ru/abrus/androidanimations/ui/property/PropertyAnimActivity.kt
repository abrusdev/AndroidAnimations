package ru.abrus.androidanimations.ui.property

import android.animation.Animator
import android.animation.AnimatorInflater
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.animation.addListener
import kotlinx.android.synthetic.main.activity_property_anim.*
import ru.abrus.androidanimations.R

class PropertyAnimActivity : AppCompatActivity() {
    companion object{
        private const val TAG = "PropertyAnimation"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_anim)

        fadeBtn.setOnClickListener { animate(R.animator.fade) }

        scaleBtn.setOnClickListener { animate(R.animator.scale) }

        rotateBtn.setOnClickListener { animate(R.animator.rotate) }

        translateBtn.setOnClickListener { animate(R.animator.translate) }
    }

    private fun Animator.initListener() {
        addListener({
            Log.i(TAG, "initListener: onEnd")
        }, {
            Log.i(TAG, "initListener: onStart")
        }, {
            Log.i(TAG, "initListener: onCancel")
        }, {
            Log.i(TAG, "initListener: onRepeat")
        })
    }

    private fun animate(id: Int) {
        AnimatorInflater.loadAnimator(this, id).apply {
            setTarget(globeImage)
            initListener()
            start()
        }
    }
}