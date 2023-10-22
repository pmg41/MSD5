package com.msd5.pushpeers.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.msd5.pushpeers.BuildConfig
import com.msd5.pushpeers.network.ApiDataSource
import com.msd5.pushpeers.network.ApiRepository
import com.msd5.pushpeers.network.ApiServices
import com.msd5.pushpeers.utils.NullOnEmptyConverterFactory
import com.msd5.pushpeers.utils.SharedPreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    val BASE_URL = "http://demo.com/"

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        val cookieManager = CookieManager()
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL)
        val httpClientBuilder = OkHttpClient.Builder()
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        httpClientBuilder.cookieJar(JavaNetCookieJar(cookieManager))
        httpClientBuilder.addInterceptor(headerInterceptor())
        httpClientBuilder.addInterceptor(httpLoggingInterceptor)

        val gson = GsonBuilder()
            .setLenient()
            .create()
        val client = httpClientBuilder
            .readTimeout(30, TimeUnit.MINUTES)
            .writeTimeout(30, TimeUnit.MINUTES)
            .connectTimeout(30, TimeUnit.MINUTES)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(NullOnEmptyConverterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    //adding data to header to make api request
    private fun headerInterceptor(): Interceptor {

        return Interceptor { chain ->
            var request: Request = chain.request()
            request = request.newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "*/*")
                .method(request.method, request.body)
                .build()
            chain.proceed(request)
        }
    }

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiServices =
        retrofit.create(ApiServices::class.java)

    @Singleton
    @Provides
    fun provideApiDataSource(
        apiServices: ApiServices,
        sharedPreferenceManager: SharedPreferenceManager,
        @ApplicationContext context: Context
    ) = ApiDataSource(apiServices, sharedPreferenceManager, context)

    @Singleton
    @Provides
    fun provideRepository(apiDataSource: ApiDataSource) =
        ApiRepository(apiDataSource)

}