package com.tilak.apps.moshi.data.respository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.tilak.apps.moshi.data.AirlineModel
import com.tilak.apps.moshi.utilities.FileHelper

class AirlinesRepo(var app: Application) {

    val listAirlinesData = MutableLiveData<List<AirlineModel>>()

    private var listType = Types.newParameterizedType(
        List::class.java, AirlineModel::class.java
    )

    init {
        getAirlinesListFromAssets()
    }

    private fun getAirlinesListFromAssets() {
        val text = FileHelper.getTextFromAssets(app, "airlines.son.json")
        val moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<List<AirlineModel>> = moshi.adapter(listType)
        listAirlinesData.value = adapter.fromJson(text) ?: emptyList()
    }
}