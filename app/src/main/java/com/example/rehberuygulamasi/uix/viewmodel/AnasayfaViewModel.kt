package com.example.rehberuygulamasi.uix.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rehberuygulamasi.data.entity.Kisiler
import com.example.rehberuygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class AnasayfaViewModel@Inject constructor(var kRepo: KisilerRepository) : ViewModel() {
    var kisilerListesi= MutableLiveData<List<Kisiler>>()



    init {
        kisileriYukle()
    }

    fun sil(kisi_id:String){

         kRepo.sil(kisi_id)


    }
    fun kisileriYukle(){

           kisilerListesi =  kRepo.kisileriYukle()

    }

    fun ara(aramaKelimesi: String ){
            kisilerListesi=  kRepo.ara(aramaKelimesi)


    }

}