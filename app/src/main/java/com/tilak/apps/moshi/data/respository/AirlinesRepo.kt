package com.tilak.apps.moshi.data.respository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.tilak.apps.moshi.R
import com.tilak.apps.moshi.data.model.AirlineModel
import com.tilak.apps.moshi.utilities.AppConstants
import com.tilak.apps.moshi.utilities.FileHelper
import com.tilak.apps.moshi.utilities.LogHelper

class AirlinesRepo(var app: Application) {

    val listAirlinesData = MutableLiveData<List<AirlineModel>>()

    private var listType = Types.newParameterizedType(
        List::class.java, AirlineModel::class.java
    )

    fun getAirlinesListFromAssets() {
        LogHelper.logMessage(AppConstants.TAG_LOGS, "getAirlinesListFromAssets")
        val text = FileHelper.getTextFromAssets(app, "airlines.son.json")
        val moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<List<AirlineModel>> = moshi.adapter(listType)
        listAirlinesData.value = adapter.fromJson(text) ?: emptyList()
    }

    fun getAirlinesListFromResource() {
        LogHelper.logMessage(AppConstants.TAG_LOGS, "getAirlinesListFromResource")
        val text = FileHelper.getTextFromResources(app, R.raw.airlines)
        val moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<List<AirlineModel>> = moshi.adapter(listType)
        listAirlinesData.value = adapter.fromJson(text) ?: emptyList()
    }
}