package com.rutvikpatel.snappy1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class signuppage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signuppage)
        val decorView = window.decorView
        val uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
        uiOptions.also { decorView.systemUiVisibility = it }
        findViewById<Button>(R.id.signuploginbutton).setOnClickListener{
            Intent(this,MainActivity::class.java).also { startActivity(it) }
        }
        findViewById<Button>(R.id.signupnextbutton).setOnClickListener{
            val password = findViewById<EditText>(R.id.signuppassword).text
            val confirmpassword =findViewById<EditText>(R.id.signupconfirmpassword).text
            val mobile = findViewById<EditText>(R.id.signupmobilenumber).text.length
            var matcher = false
            if (mobile == 10){
                if (password==confirmpassword){
                    val pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%^&*()_+\\-\\[\\]{};':\"\\\\|,.<>?]).{8,}$")
                    matcher = pattern.matcher(password).matches()
                    if(matcher){
                            Toast.makeText(this,"Login Successfull",Toast.LENGTH_SHORT)
                    }
                    else{
                        findViewById<EditText>(R.id.signuppassword).error = "Password must be Strong"
                    }
                }
                else{
                    findViewById<EditText>(R.id.signupconfirmpassword).error = "Password must be same"
                }
            }
            else{
                findViewById<EditText>(R.id.signupmobilenumber).error = "Please Enter Valid mobile number"
            }


        }
    }
}