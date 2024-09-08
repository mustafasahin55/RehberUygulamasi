package com.example.rehberuygulamasi.di
import com.example.rehberuygulamasi.data.datasource.KisilerDataSource
import com.example.rehberuygulamasi.data.repo.KisilerRepository
import com.example.rehberuygulamasi.retrofit.ApiUtils
import com.example.rehberuygulamasi.retrofit.KisilerDao
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
    fun provideKisilerDataSource(kisilerDao: KisilerDao): KisilerDataSource {
        return KisilerDataSource(kisilerDao)

    }
    @Provides
    @Singleton
    fun provideKisilerDao(): KisilerDao {
        return ApiUtils.getKisilerDao()
    }



}