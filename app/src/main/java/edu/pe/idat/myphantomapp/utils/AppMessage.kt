package edu.pe.idat.myphantomapp.utils

import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import edu.pe.idat.myphantomapp.R


object AppMessage {
    fun sendMessage(view: View, message: String, type: TypeMessage){
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
        val snackbarView: View = snackbar.view
        if(type == TypeMessage.ERROR){
            snackbarView.setBackgroundColor(
                ContextCompat.getColor(MyApp.INSTANCE,
                    R.color.snackbar_error)
            )
        }else{
            snackbarView.setBackgroundColor(
                ContextCompat.getColor(MyApp.INSTANCE,
                    R.color.snackbar_success)
            )
        }
        snackbar.show()
    }
}