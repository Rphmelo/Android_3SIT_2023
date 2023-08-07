package br.com.fiap.countries

import android.view.View
import com.google.android.material.snackbar.Snackbar

object SnackBarUtil {

    fun showSnackBar(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
    }
}