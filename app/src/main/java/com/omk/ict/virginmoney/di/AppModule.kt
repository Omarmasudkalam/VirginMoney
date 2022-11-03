package com.omk.ict.virginmoney.di

import com.omk.ict.virginmoney.model.data.ApiDetails
import com.omk.ict.virginmoney.model.data.GetApiResponse
import com.omk.ict.virginmoney.repository.Repository
import com.omk.ict.virginmoney.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module // to define the definition of  depoendancy injection
@InstallIn(SingletonComponent::class) //to define the scope of dependancy injection
class AppModule {
    //define all the dependancies you will use
    @Provides
    //provide the retrofit instance
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(ApiDetails.BASE_URL)
        .build()

    @Provides
    //to provide the API instance references in code use
    fun provideEmployeeAPI(retrofit: Retrofit): GetApiResponse =retrofit.create(GetApiResponse::class.java)


    @Provides
    fun provideRepository(
        employeeApi: GetApiResponse
    ): Repository {
        return RepositoryImpl(employeeApi)
    }
}