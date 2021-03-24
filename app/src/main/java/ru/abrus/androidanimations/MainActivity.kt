package ru.abrus.androidanimations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.abrus.androidanimations.data.MainData
import ru.abrus.androidanimations.ui.adapters.MainAdapter
import ru.abrus.androidanimations.ui.choreographing.ChoreographingAnimActivity
import ru.abrus.androidanimations.ui.property.PropertyAnimActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        recyclerMain.adapter = MainAdapter {
            startActivity(it)
        }.apply {
            data = arrayListOf(
                MainData("Property Animation", PropertyAnimActivity::class.java),
                MainData("Choreographing Animation", ChoreographingAnimActivity::class.java)

            )
        }

    }

    private fun startActivity(cls: Class<*>) {
        startActivity(Intent(this@MainActivity, cls))
    }
}