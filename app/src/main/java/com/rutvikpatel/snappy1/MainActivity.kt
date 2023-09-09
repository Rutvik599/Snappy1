package com.rutvikpatel.snappy1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val decorView = window.decorView
        val uiOptions = SYSTEM_UI_FLAG_FULLSCREEN
        uiOptions.also { decorView.systemUiVisibility = it }

        findViewById<Button>(R.id.signupbutton).setOnClickListener{
            Intent(this,signuppage::class.java).also{startActivity(it)}
        };
    }
}