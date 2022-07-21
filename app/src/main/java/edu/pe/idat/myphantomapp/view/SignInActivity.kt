package edu.pe.idat.myphantomapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import edu.pe.idat.myphantomapp.R
import edu.pe.idat.myphantomapp.databinding.ActivitySignInBinding
import edu.pe.idat.myphantomapp.retrofit.responses.ResponseLogin
import edu.pe.idat.myphantomapp.utils.AppMessage
import edu.pe.idat.myphantomapp.utils.TypeMessage
import edu.pe.idat.myphantomapp.viewmodel.AuthViewModel

class SignInActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        authViewModel = ViewModelProvider(this)
            .get(AuthViewModel::class.java)

        binding.btnSignIn.setOnClickListener(this)
        binding.btnSignUp.setOnClickListener(this)

        //Go to main when login is ok
        authViewModel.responseLogin.observe(this, {
            getLoginResponseData(it!!)
        })
    }

    private fun setStatusButtons(boolean: Boolean){
        binding.btnSignIn.isEnabled = boolean
        binding.btnSignUp.isEnabled = boolean
    }
    private fun validateInputs(): Boolean{
        if(binding.tiEmail.text.toString().trim().isEmpty()){
            binding.tiEmail.isFocusableInTouchMode = true
            binding.tiEmail.requestFocus()
            return false
        }else if (binding.tiPassword.text.toString().trim().isEmpty()){
            binding.tiPassword.isFocusableInTouchMode = true
            binding.tiPassword.requestFocus()
            return false
        }
        return true
    }

    private fun getLoginResponseData(it: ResponseLogin) {
        if (it.jwt?.isNotEmpty() == true){
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }else{
            AppMessage.sendMessage(binding.root, "Email o password incorrecto", TypeMessage.ERROR)
        }
        setStatusButtons(true)
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.btn_sign_in -> authenticateUser()
            R.id.btn_sign_up -> startActivity(Intent(applicationContext, SignUpActivity::class.java))
        }
    }

    private fun authenticateUser() {
        setStatusButtons(false)
        val validInputs = validateInputs()
        if(validInputs){
            authViewModel.authenticateUser(
                binding.tiEmail.text.toString(),
                binding.tiPassword.text.toString()
            )
        }else{
            binding.btnSignIn.isEnabled = true
            AppMessage.sendMessage(binding.root, "Ingrese su usuario y password", TypeMessage.ERROR)
        }
    }
}