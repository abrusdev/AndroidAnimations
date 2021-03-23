package ru.abrus.androidanimations.ui.property

import android.animation.AnimatorInflater
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_property_anim.*
import ru.abrus.androidanimations.R

class PropertyAnimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_anim)

        fadeBtn.setOnClickListener { animate(R.animator.fade) }

        scaleBtn.setOnClickListener { animate(R.animator.scale) }

        rotateBtn.setOnClickListener { animate(R.animator.rotate) }

        translateBtn.setOnClickListener { animate(R.animator.translate) }

    }

    private fun animate(id: Int) {
        val animator = AnimatorInflater.loadAnimator(this, id)
        animator.setTarget(globeImage)
        animator.start()
    }
}