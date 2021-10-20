package com.ssepulveda.di

import com.ssepulveda.data.HistoryRemoteDataSource
import com.ssepulveda.data.RocketsRemoteDataSource
import com.ssepulveda.network.services.SpaceXService
import com.ssepulveda.provider.FavoriteProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v4/")
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): SpaceXService = retrofit.create(SpaceXService::class.java)

    @Provides
    @Singleton
    fun provideHistoryRemoteDataSource(service: SpaceXService) = HistoryRemoteDataSource(service)

    @Provides
    @Singleton
    fun provideRocketsRemoteDataSource(service: SpaceXService) = RocketsRemoteDataSource(service)

    @Provides
    @Singleton
    fun provideFavoriteProvider() = FavoriteProvider()

}