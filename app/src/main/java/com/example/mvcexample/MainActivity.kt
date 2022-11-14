package com.example.mvcexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mvcexample.Controller.ILoginController
import com.example.mvcexample.Controller.LoginController
import com.example.mvcexample.View.ILoginView

class MainActivity : AppCompatActivity(), ILoginView {
    var email: EditText? = null
    var password: EditText? = null
    var loginb: Button? = null
    var loginPresenter: ILoginController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email = findViewById(R.id.edtUserName)
        password = findViewById(R.id.edtPassword)
        loginb = findViewById(R.id.mButtonLogin)
        loginPresenter=LoginController(this)

        loginb?.setOnClickListener {
            (loginPresenter as LoginController).OnLogin(email?.text.toString(), password?.text.toString())
        }

    }

    override fun OnLoginSuccess(message: String?) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }

    override fun OnLoginError(message: String?) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}