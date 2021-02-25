package com.tilak.apps.moshi.ui.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.tilak.apps.moshi.data.respository.AirlinesRepo
import com.tilak.apps.moshi.utilities.SourceType

class ListViewModel(app: Application) : AndroidViewModel(app) {

    private val dataRepo = AirlinesRepo(app)


    fun fetchAirlinesList(sourceType: SourceType) {
        when (sourceType) {

            SourceType.ASSETS -> {
                dataRepo.getAirlinesListFromAssets()
            }

            SourceType.RESOURCE -> {
                dataRepo.getAirlinesListFromResource()
            }

            SourceType.REST_API -> {
                dataRepo.getAirlinesListFromResource()
            }
        }

    }


    val listAirlines = dataRepo.listAirlinesData

}