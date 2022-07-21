package edu.pe.idat.myphantomapp.utils

import android.app.Application
import android.content.Context

class MyApp : Application() {
    init { INSTANCE = this }

    //Agrupa todos las variables y métodos que están definidos como
    //estáticos
    companion object {
        lateinit var INSTANCE: MyApp
            private set

        val applicationContext: Context get() { return INSTANCE.applicationContext }
    }
}