package com.example.figmaapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.figmaapplication.retrofit.AuthRequest
import com.example.figmaapplication.retrofit.MainAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SignInActivity : AppCompatActivity() {
    private lateinit var mainApi: MainAPI
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var btnSignIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        btnSignIn = findViewById(R.id.SignInBtn)
    }

    private fun initRetrofit() {
        val interceptor = HttpLoggingInterceptor()
       interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
       .baseUrl("https://dummyjson.com").client(client)
       .addConverterFactory(GsonConverterFactory.create()).build()
       mainApi = retrofit.create(MainAPI::class.java)
    }

    private fun auth(authRequest: AuthRequest) {
        initRetrofit()
//        var message: String? = ""
        CoroutineScope(Dispatchers.IO).launch{
            val response = mainApi.auth(authRequest)
            val message = response.errorBody()?.string()?.let {
                JSONObject(it).getString("message")
            }


            val user = response.body()
            if(user != null){
//                binding.name.text = user.firstName
//                btnSignIn.visibility = View.VISIBLE

//                viewModel.token.value = user.token

                val intent = Intent(this@SignInActivity, MenuActivity::class.java)
                startActivity(intent)
                finish()
            }
//            else {
//                val alert = AlertDialog.Builder(this@SignInActivity) //создание окна
//                    .setTitle("Ошибка") //заголовок
//                    .setMessage("Логин и/или пароль введены неверно") //сообщение
//                    .setPositiveButton("0k",null) //добавление кнопки
//                    .create()
//                    .show() //вывод на экран|
//            }
        }
//        return message == ""

    }

    fun signin(view: View) {
        initRetrofit()
        val status = auth(
            AuthRequest(
            email.text.toString(),
            password.text.toString()
        )
        )
//        if(email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {
//        if (status) {
//            val intent = Intent(this,MenuActivity::class.java)
//            startActivity(intent)
//            finish()
//        }


//        else {
//            val alert = AlertDialog.Builder(this) //создание окна
//                .setTitle("Ошибка") //заголовок
//                .setMessage("У вас есть незаполненные поля") //сообщение
//                .setPositiveButton("0k",null) //добавление кнопки
//                .create()
//                .show() //вывод на экран|
    }


}
