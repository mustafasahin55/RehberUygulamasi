package com.example.rehberuygulamasi.di
import com.example.rehberuygulamasi.data.datasource.KisilerDataSource
import com.example.rehberuygulamasi.data.repo.KisilerRepository
import com.google.firebase.Firebase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideKisilerRepository(kds: KisilerDataSource): KisilerRepository {
        return KisilerRepository(kds)
    }

    @Provides
    @Singleton
    fun provideKisilerDataSource(collectionKisiler:CollectionReference): KisilerDataSource {
        return KisilerDataSource(collectionKisiler)

    }
    @Provides
    @Singleton
    fun provideCollectionReferance(): CollectionReference {
        return Firebase.firestore.collection("Kisiler")

    }
}