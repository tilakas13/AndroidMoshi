package com.tilak.apps.moshi.ui.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.tilak.apps.moshi.data.respository.AirlinesRepo

class ListViewModel(app: Application) : AndroidViewModel(app) {
    private val dataRepo = AirlinesRepo(app)

    val listAirlines = dataRepo.listAirlinesData

}