package com.cours.etalonschat.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.cours.etalonschat.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import kotlin.math.log

class AuthentificationActivity : AppCompatActivity() {

    lateinit var viewRegister : TextView
    lateinit var layoutTextInputEmail : TextInputLayout
    lateinit var layoutTextInputPassword : TextInputLayout
    lateinit var btnConnect : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentification)

        viewRegister = findViewById(R.id.viewRegister)
        layoutTextInputEmail = findViewById(R.id.layoutTextInputEmail)
        layoutTextInputPassword = findViewById(R.id.layoutTextInputPassword)
        btnConnect = findViewById(R.id.btnConnect)

        //Passer de authentification a register grace au textView en bas.
        viewRegister.setOnClickListener {
            Intent(this, RegisterActivity::class.java).also {
                startActivity(it)
            }
        }

        btnConnect.setOnClickListener {

            layoutTextInputPassword.isErrorEnabled = false
            layoutTextInputEmail.isErrorEnabled = false

            val email = layoutTextInputEmail.editText?.text.toString()
            val password = layoutTextInputPassword.editText?.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                if(password.isEmpty()){
                    layoutTextInputPassword.error = "Mot de passe obligatoire!"
                    layoutTextInputPassword.isErrorEnabled = true
                }
                if(email.isEmpty()){
                    layoutTextInputEmail.error = "Email obligatoire!"
                    layoutTextInputEmail.isErrorEnabled = true
                }
            }else{
                signIn(email, password)
            }


        }

    }

    fun signIn(email:String , password:String){
        Log.d("signIn", "signIn user")
        if(email == "tabsoba@gmail.com" && password == "test1234"){
            Intent(this, HomeActivity::class.java).also {
                startActivity(it)
            }
            finish()
        }else{
            layoutTextInputPassword.error = "Authentification Echouer!"
            layoutTextInputEmail.isErrorEnabled = true
            layoutTextInputPassword.isErrorEnabled = true
        }

    }
}