package com.example.rehberuygulamasi.uix.viewmodel

import androidx.lifecycle.ViewModel
import com.example.rehberuygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiDetaySayfaViewModel@Inject constructor(var kRepo: KisilerRepository): ViewModel() {

     fun guncelle(kisi_id:String,kisi_ad: String, kisi_tel: String){
             kRepo.guncelle(kisi_id,kisi_ad,kisi_tel)

     }
}