package com.example.rehberuygulamasi.retrofit

import com.example.rehberuygulamasi.data.entity.CRUDCevap
import com.example.rehberuygulamasi.data.entity.KisilerCevap
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface KisilerDao {
    //http://kasimadalan.pe.hu/kisiler/tum_kisiler.php
    //http://kasimadalan.pe.hu/ -> base url
    //kisiler/tum_kisiler.php -> '?a=t'

    @GET("kisiler/tum_kisiler.php")
    suspend fun kisileriYukle() : KisilerCevap

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    suspend fun kaydet(@Field("kisi_ad") kisi_ad:String,@Field("kisi_tel") kisi_tel:String) : CRUDCevap


}