package com.posart.githubinfo.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.posart.githubinfo.R
import com.posart.githubinfo.viewmodels.ProgressStatus

fun View.updateScreen(views: List<View>, status: ProgressStatus) {
    when (status) {

        ProgressStatus.LOADING ->
            views.forEach { view ->
                view.visibility = View.INVISIBLE
                if (view.id == R.id.progressBar) {
                    view.visibility = View.VISIBLE
                }
            }

        ProgressStatus.CONCLUDED -> {
            views.forEach { view ->
                view.visibility = View.VISIBLE
                if (view.id == R.id.progressBar) {
                    view.visibility = View.GONE
                }
            }
            Snackbar.make(this, "Busca realizada com sucesso", Snackbar.LENGTH_LONG).show()
        }


        ProgressStatus.ERROR -> {
            views.forEach { view ->
                view.visibility = View.INVISIBLE
            }
            Snackbar.make(this, "Falha ao buscar dados do usuário", Snackbar.LENGTH_LONG).show()
        }

    }
}