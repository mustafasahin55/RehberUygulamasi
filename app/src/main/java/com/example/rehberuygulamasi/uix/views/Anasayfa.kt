package com.example.rehberuygulamasi.uix.views

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rehberuygulamasi.R
import com.example.rehberuygulamasi.data.entity.Kisiler
import com.example.rehberuygulamasi.uix.viewmodel.AnasayfaViewModel
import com.google.gson.Gson
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(navController: NavController,anasayfaViewModel: AnasayfaViewModel) {
    val kisilerListesi = anasayfaViewModel.kisilerListesi.observeAsState(listOf())
    LaunchedEffect(key1 = true) {
        anasayfaViewModel.kisileriYukle()
    }


    val aramaYapiliyorMu = remember {
        mutableStateOf(false)
    }

    val tf = remember {
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()
    val snackbarHostState  = remember {
        SnackbarHostState()
    }







    Scaffold(topBar = {


        TopAppBar(


            title = {
                if (aramaYapiliyorMu.value) {
                    TextField(
                        value = tf.value,
                        onValueChange = { tf.value = it



                                        },
                        label = { Text(text = "Ara")},
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.Black,
                            unfocusedIndicatorColor = Color.White)

                        )

                    anasayfaViewModel.ara(tf.value)
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


        },
        snackbarHost = {SnackbarHost(hostState = snackbarHostState)

        }

    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            items(count = kisilerListesi.value.count(),
                itemContent = {
                    val kisi = kisilerListesi.value[it]
                    Card(
                        modifier = Modifier.padding(all = 5.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillParentMaxWidth()
                                .padding(10.dp)
                                .clickable {
                                    val kisiJson = Gson().toJson(kisi)
                                    navController.navigate("kisiDetaySayfa/$kisiJson")
                                },
                            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            Column(
                                modifier = Modifier.padding(all = 4.dp)
                            ) {
                              Text(text = kisi.kisi_ad, fontSize = 20.sp)
                                Spacer(modifier = Modifier.size(4.dp))
                              Text(text = kisi.kisi_tel)
                            }

                            IconButton(onClick = {
                                scope.launch {
                                    val sb = snackbarHostState.showSnackbar(
                                        message = "${kisi.kisi_ad} silinsin mi",
                                        actionLabel = "EVET"
                                    )

                                    if(sb == SnackbarResult.ActionPerformed){
                                        anasayfaViewModel.sil(kisi_id = kisi.kisi_id)
                                    }
                                }



                            }) {
                                Icon(painter = painterResource(id = R.drawable.close_icon), contentDescription ="", tint = Color.Gray )
                            }
                            
                            
                        }
                    }
                }


            )
        }


    }


}