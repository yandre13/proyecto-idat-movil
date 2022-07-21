package edu.pe.idat.myphantomapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import edu.pe.idat.myphantomapp.R
import edu.pe.idat.myphantomapp.databinding.ActivitySignUpBinding
import edu.pe.idat.myphantomapp.retrofit.responses.ResponseUser
import edu.pe.idat.myphantomapp.utils.AppMessage
import edu.pe.idat.myphantomapp.utils.TypeMessage
import edu.pe.idat.myphantomapp.viewmodel.AuthViewModel

class SignUpActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        authViewModel = ViewModelProvider(this)
            .get(AuthViewModel::class.java)
        binding.btnSignUpUser.setOnClickListener(this)
        binding.btnGoLoginUser.setOnClickListener(this)

        authViewModel.responseUser.observe(this,
            {
                getUserResponseData(it!!)
            })
    }
    private fun setStatusButtons(boolean: Boolean){
        binding.btnGoLoginUser.isEnabled = boolean
        binding.btnSignUpUser.isEnabled = boolean
    }

    private fun getUserResponseData(it: ResponseUser) {
        if (it.id !== null){
            resetInputs()
            AppMessage.sendMessage(binding.root, "Registrado con éxito", TypeMessage.SUCCESS)
            startActivity(Intent(applicationContext, SignInActivity::class.java))
        }else{
            AppMessage.sendMessage(binding.root, "Lo sentimos, ocurrió un error", TypeMessage.ERROR)
        }
        setStatusButtons(true)
    }

    private fun resetInputs() {
        binding.tiNameUser.setText("")
        binding.tiLastnameUser.setText("")
        binding.tiEmailUser.setText("")
        binding.tiPhoneUser.setText("")
        binding.tiPasswordUser.setText("")
        binding.tiConfirmPasswordUser.setText("")
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.btn_go_login_user -> startActivity(Intent(applicationContext, SignInActivity::class.java))
            R.id.btn_sign_up_user -> createUser()
        }
    }

    private fun createUser() {
        setStatusButtons(false)

        if (validateForm()){
            authViewModel.createUser(
                binding.tiNameUser.text.toString(),
                binding.tiLastnameUser.text.toString(),
                "${binding.tiNameUser.text.toString()}_${binding.tiLastnameUser.text.toString()}",
                binding.tiEmailUser.text.toString(),
                binding.tiPasswordUser.text.toString()
            )
        }else{
            setStatusButtons(true)
        }
    }

    private fun validateForm(): Boolean {
        var response = true
        var message = ""
        when{
            binding.tiNameUser.text.toString().trim().isEmpty() ->{
                binding.tiNameUser.isFocusableInTouchMode = true
                binding.tiNameUser.requestFocus()
                message = "Ingrese su nombre"
                response = false
            }
            binding.tiLastnameUser.text.toString().trim().isEmpty() ->{
                binding.tiLastnameUser.isFocusableInTouchMode = true
                binding.tiLastnameUser.requestFocus()
                message = "Ingrese su apellido"
                response = false
            }
            binding.tiEmailUser.text.toString().trim().isEmpty() ->{
                binding.tiEmailUser.isFocusableInTouchMode = true
                binding.tiEmailUser.requestFocus()
                message = "Ingrese su email"
                response = false
            }
            binding.tiPhoneUser.text.toString().trim().isEmpty() ->{
                binding.tiPhoneUser.isFocusableInTouchMode = true
                binding.tiPhoneUser.requestFocus()
                message = "Ingrese su celular"
                response = false
            }
            binding.tiPasswordUser.text.toString().trim().isEmpty() ->{
                binding.tiPasswordUser.isFocusableInTouchMode = true
                binding.tiPasswordUser.requestFocus()
                message = "Ingrese su password"
                response = false
            }
            binding.tiConfirmPasswordUser.text.toString().trim().isNotEmpty() ->{
                if(binding.tiConfirmPasswordUser.text.toString() != binding.tiPasswordUser.text.toString()){
                    binding.tiConfirmPasswordUser.isFocusableInTouchMode = true
                    binding.tiConfirmPasswordUser.requestFocus()
                    message = "Password no coincide"
                    response = false
                }
            }
        }
        if (!response) AppMessage.sendMessage(binding.root, message,
            TypeMessage.ERROR)
        return response
    }
}