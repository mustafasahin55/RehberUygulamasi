package com.example.rehberuygulamasi.uix.viewmodel

import androidx.lifecycle.ViewModel
import com.example.rehberuygulamasi.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisiDetaySayfaViewModel: ViewModel() {
    var kRepo = KisilerRepository()
     fun guncelle(kisi_id:Int,kisi_ad: String, kisi_tel: String){
         CoroutineScope(Dispatchers.Main).launch {
             kRepo.guncelle(kisi_id,kisi_ad,kisi_tel)
         }
     }
}