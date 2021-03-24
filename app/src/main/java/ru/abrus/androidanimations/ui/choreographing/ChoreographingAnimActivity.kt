package ru.abrus.androidanimations.ui.choreographing

import android.animation.AnimatorInflater
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
    }
}