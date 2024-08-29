package com.example.rehberuygulamasi.uix.viewmodel

import androidx.lifecycle.ViewModel
import com.example.rehberuygulamasi.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisiKayitSayfaViewModel : ViewModel() {
    var kRepo = KisilerRepository()

    fun kaydet(kisi_ad: String, kisi_tel: String) {
        CoroutineScope(Dispatchers.Main).launch {
            kRepo.kaydet(kisi_ad, kisi_tel)
        }

    }

}