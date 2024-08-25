package com.example.rehberuygulamasi.uix

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rehberuygulamasi.data.entity.Kisiler

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KisiDetaySayfa(gelenKisi:Kisiler) {
    val tfKisiAd = remember {
        mutableStateOf("")
    }
    val tfKisiTel = remember {
        mutableStateOf("")
    }


    LaunchedEffect(key1 = true) {
        tfKisiAd.value = gelenKisi.kisi_ad
        tfKisiTel.value = gelenKisi.kisi_tel

    }


    fun guncelle(kisi_id:Int,kisi_ad: String, kisi_tel: String) {
        Log.e("KisiGuncelle", "$kisi_id-$kisi_ad-$kisi_tel")
    }

    Scaffold(topBar = { TopAppBar(title = { Text(text = "kisi Kayit") }) }) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            TextField(value = tfKisiAd.value, onValueChange = { tfKisiAd.value = it }, label = {
                Text(
                    text = "Kişi Ad"
                )
            })
            TextField(value = tfKisiTel.value, onValueChange = { tfKisiTel.value = it }, label = {
                Text(
                    text = "Kişi Tel"
                )
            })
            Button(onClick = { guncelle(gelenKisi.kisi_id,tfKisiAd.value,tfKisiTel.value) },
                modifier = Modifier.size(250.dp,50.dp)
            ) {
                Text(text = "Güncelle")
            }

        }


    }


}