package com.rutvikpatel.snappy1

import android.content.Intent
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rutvikpatel.snappy1.databinding.ActivityMainBinding
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {
    private  lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userData = UserData("hello", "hii")
        runBlocking {
            sendUserData(userData)
        }
        Toast.makeText(this,"Login Successfull",Toast.LENGTH_SHORT).show()
        setContentView(R.layout.activity_main)
        val decorView = window.decorView
        val uiOptions = SYSTEM_UI_FLAG_FULLSCREEN
        uiOptions.also { decorView.systemUiVisibility = it }

        binding.loginbutton.setOnClickListener{
            val userid = binding.loginmobilenumber.text.toString()
            val password = binding.loginpassword.text.toString()
            val userData = UserData("hello", "hii")
            runBlocking {
                sendUserData(userData)
            }
            Toast.makeText(this,"Login Successfull",Toast.LENGTH_SHORT).show()
        }
    }
    suspend fun sendUserData(userData: UserData) {
        val client = HttpClient {
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
        }

        val url = "http://localhost:3000/api/user"
        client.post<Unit> {
            url(url)
            contentType(ContentType.Application.Json)
            body = userData
        }
    }
}
data class UserData(val username: String, val password: String)
