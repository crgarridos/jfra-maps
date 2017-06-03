package com.tochange.bonjia.di.module

import android.os.Environment
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton
import okhttp3.Cache
import java.util.concurrent.TimeUnit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import com.google.gson.Gson
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
//import com.tochange.bonjia.di.qualifier.Cached
//import com.tochange.bonjia.di.qualifier.NonCached


@Module
class NetModule {
    @Singleton
    @Provides
//    @Cached
    fun provideOkHttpClient(): OkHttpClient {
        val cache = Cache(Environment.getDownloadCacheDirectory(), 10 * 1024 * 1024)
        return OkHttpClient.Builder()
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .cache(cache)
                .build()
    }

//    @Singleton
//    @Provides
//    @NonCached
//    fun provideNonCachedOkHttpClient(): OkHttpClient {
//        return OkHttpClient.Builder()
//                .readTimeout(1, TimeUnit.MINUTES)
//                .writeTimeout(1, TimeUnit.MINUTES)
//                .build()
//    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
    }

    /**
     * Example service
     */
    /*@Provides
    @Singleton
    WordpressService provideService(Retrofit.Builder builder) {
        return builder.baseUrl(BuildConfig.API_URL)
                .build()
                .create(WordpressService.class);
    }
    */
}