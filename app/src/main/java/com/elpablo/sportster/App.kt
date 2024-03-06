package com.elpablo.sportster

import android.app.Application
import androidx.compose.ui.res.stringResource
import com.google.firebase.FirebaseApp
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        MapKitFactory.setApiKey(getString(R.string.ya_ru))
        MapKitFactory.initialize(this)
    }
}