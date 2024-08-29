package com.example.rehberuygulamasi.uix.views

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rehberuygulamasi.uix.viewmodel.KisiKayitSayfaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KisiKayitSayfa(kisiKayitSayfaViewModel: KisiKayitSayfaViewModel) {
    val tfKisiAd = remember {
        mutableStateOf("")
    }
    val tfKisiTel = remember {
        mutableStateOf("")
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
            Button(onClick = { kisiKayitSayfaViewModel.kaydet(tfKisiAd.value, tfKisiTel.value) },
                modifier = Modifier.size(250.dp,50.dp)
                ) {
                Text(text = "Kaydet")
            }

        }


    }


}