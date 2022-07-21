package edu.pe.idat.myphantomapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import edu.pe.idat.myphantomapp.repository.AuthRepository
import edu.pe.idat.myphantomapp.retrofit.requests.RequestLogin
import edu.pe.idat.myphantomapp.retrofit.requests.RequestUser
import edu.pe.idat.myphantomapp.retrofit.responses.ResponseLogin
import edu.pe.idat.myphantomapp.retrofit.responses.ResponseUser

class AuthViewModel: ViewModel() {
    var responseLogin: LiveData<ResponseLogin>
    var responseUser: LiveData<ResponseUser>

    private var repository = AuthRepository()

    init {
        responseLogin = repository.loginResponse
        responseUser = repository.userResponse
    }

    fun authenticateUser(email: String, password: String){
        responseLogin = repository.authenticateUser(RequestLogin(email, password))
    }

    fun createUser(
        name: String,
        lastname: String,
        username: String,
        email: String,
        password: String
    ){
        responseUser = repository.createUser(RequestUser(name, lastname, username, email, password))
    }

}