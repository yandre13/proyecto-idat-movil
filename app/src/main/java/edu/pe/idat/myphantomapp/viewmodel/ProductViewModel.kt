package edu.pe.idat.myphantomapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import edu.pe.idat.myphantomapp.repository.ProductRepository
import edu.pe.idat.myphantomapp.retrofit.responses.ResponseListProducts

class ProductViewModel: ViewModel() {

    private var repository = ProductRepository()

    fun listAllProducts(): LiveData<ResponseListProducts>{
        return repository.listAllProducts()
    }


}