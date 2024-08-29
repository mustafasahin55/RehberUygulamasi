package com.example.rehberuygulamasi.uix.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rehberuygulamasi.data.entity.Kisiler
import com.example.rehberuygulamasi.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnasayfaViewModel : ViewModel() {
    var kisilerListesi= MutableLiveData<List<Kisiler>>()
    var kRepo = KisilerRepository()

    init {
        kisileriYukle()
    }

    fun sil(kisi_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
         kRepo.sil(kisi_id)
            kisileriYukle()

        }
    }
    fun kisileriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
           kisilerListesi.value=  kRepo.kisileriYukle()
        }
    }

    fun ara(aramaKelimesi: String){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value=  kRepo.ara(aramaKelimesi)
        }

    }

}