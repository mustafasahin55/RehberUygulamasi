package com.example.rehberuygulamasi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.rehberuygulamasi.ui.theme.RehberUygulamasiTheme
import com.example.rehberuygulamasi.uix.viewmodel.AnasayfaViewModel
import com.example.rehberuygulamasi.uix.viewmodel.KisiDetaySayfaViewModel
import com.example.rehberuygulamasi.uix.viewmodel.KisiKayitSayfaViewModel
import com.example.rehberuygulamasi.uix.views.SayfaGecisleri

class MainActivity : ComponentActivity() {
    val anasayfaViewModel: AnasayfaViewModel by viewModels()
    val kisiDetaySayfaViewModel: KisiDetaySayfaViewModel by viewModels()
    val kisiKayitSayfaViewModel: KisiKayitSayfaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RehberUygulamasiTheme {
                SayfaGecisleri(anasayfaViewModel,kisiKayitSayfaViewModel,kisiDetaySayfaViewModel)
            }
        }
    }
}

