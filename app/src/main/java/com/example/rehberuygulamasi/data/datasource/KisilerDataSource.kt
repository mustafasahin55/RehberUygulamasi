package com.example.rehberuygulamasi.data.datasource

import android.util.Log
import com.example.rehberuygulamasi.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource {

    suspend fun kaydet(kisi_ad: String, kisi_tel: String) {
        Log.e("KisiKaydet", "$kisi_ad-$kisi_tel")
    }

    suspend fun guncelle(kisi_id:Int,kisi_ad: String, kisi_tel: String) {
        Log.e("KisiGuncelle", "$kisi_id-$kisi_ad-$kisi_tel")
    }
    suspend fun sil(kisi_id:Int) {

        Log.e("Kisi Sil", kisi_id.toString())
    }

    suspend fun kisileriYukle():List<Kisiler> = withContext(Dispatchers.IO){
        val kisilerListesi = ArrayList<Kisiler>()
        val kisi1 = Kisiler(1,"Mustafa","11111")
        val kisi2 = Kisiler(1,"Mustaf","1111")
        val kisi3 = Kisiler(1,"Musta","111")
        kisilerListesi.add(kisi1)
        kisilerListesi.add(kisi2)
        kisilerListesi.add(kisi3)
        return@withContext kisilerListesi
    }

    suspend fun ara(aramaKelimesi: String):List<Kisiler> = withContext(Dispatchers.IO) {
        val kisilerListesi = ArrayList<Kisiler>()
        val kisi1 = Kisiler(1,"Mustafa","11111")

        kisilerListesi.add(kisi1)

        return@withContext kisilerListesi

    }
}