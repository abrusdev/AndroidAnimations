 package ru.abrus.androidanimations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.abrus.androidanimations.ui.property.PropertyAnimActivity

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(PropertyAnimActivity::class.java)

    }

     private fun startActivity(cls: Class<*>){
         startActivity(Intent(this@MainActivity, cls))
     }
}