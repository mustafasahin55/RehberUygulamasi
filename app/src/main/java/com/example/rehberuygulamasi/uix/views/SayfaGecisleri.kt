package com.example.rehberuygulamasi.uix.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rehberuygulamasi.data.entity.Kisiler
import com.example.rehberuygulamasi.uix.viewmodel.AnasayfaViewModel
import com.example.rehberuygulamasi.uix.viewmodel.KisiDetaySayfaViewModel
import com.example.rehberuygulamasi.uix.viewmodel.KisiKayitSayfaViewModel
import com.google.gson.Gson

@Composable
fun SayfaGecisleri(
    anasayfaViewModel: AnasayfaViewModel,
    kisiKayitSayfaViewModel: KisiKayitSayfaViewModel,
    kisiDetaySayfaViewModel: KisiDetaySayfaViewModel
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "anasayfa") {
        composable("anasayfa") {
            Anasayfa(navController,anasayfaViewModel)
        }
        composable("kisiKayitSayfa") {
            KisiKayitSayfa(kisiKayitSayfaViewModel)
        }
        composable("kisiDetaySayfa/{kisi}",
            arguments = listOf(
                navArgument("kisi") { type = NavType.StringType }

            )


        ) {
            val json = it.arguments?.getString("kisi")
            val nesne = Gson().fromJson(json, Kisiler::class.java)
            KisiDetaySayfa(nesne,kisiDetaySayfaViewModel)
        }
    }

}