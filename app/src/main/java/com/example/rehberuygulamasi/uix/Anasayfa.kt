package com.example.rehberuygulamasi.uix

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.rehberuygulamasi.R
import com.example.rehberuygulamasi.data.entity.Kisiler
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(navController: NavController) {
    val kisilerListesi = remember {
        mutableStateListOf<Kisiler>()
    }

    LaunchedEffect(key1 = true) {
        val kisi1 = Kisiler(1,"Mustafa","11111")
        val kisi2 = Kisiler(1,"Mustaf","1111")
        val kisi3 = Kisiler(1,"Musta","111")
        kisilerListesi.add(kisi1)
        kisilerListesi.add(kisi2)
        kisilerListesi.add(kisi3)
    }

    val aramaYapiliyorMu = remember {
        mutableStateOf(false)
    }

    val tf = remember {
        mutableStateOf("")
    }

    fun ara(aramaKelimesi: String) {

        Log.e("KisiAra", "$aramaKelimesi")
    }


    Scaffold(topBar = {


        TopAppBar(


            title = {
                if (aramaYapiliyorMu.value) {
                    TextField(
                        value = tf.value,
                        onValueChange = { tf.value = it },
                        label = { Text(text = "Ara")},
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.Black,
                            unfocusedIndicatorColor = Color.White)

                        )

                    ara(tf.value)
                        }
                        




                 else {
                    Text(text = "Kişiler")
                }


            },
            actions = {
                if (aramaYapiliyorMu.value) {
                    IconButton(onClick = { aramaYapiliyorMu.value = false
                    tf.value = ""
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.close_icon),
                            contentDescription = ""
                        )
                    }


                } else {
                    IconButton(onClick = { aramaYapiliyorMu.value = true }) {
                        Icon(
                            painter = painterResource(id = R.drawable.search_icon),
                            contentDescription = ""
                        )
                    }

                }


            }


        )
    },
        floatingActionButton = {

            FloatingActionButton(
                onClick = { navController.navigate("kisikayitsayfa") },
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.ekle_icon),
                        contentDescription = ""
                    )
                }

            )


        }

    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            items(count = kisilerListesi.count(),
                itemContent = {
                    val kisi = kisilerListesi[it]
                    Text(text = "${kisi.kisi_ad}")

                }


            )
        }


    }


}