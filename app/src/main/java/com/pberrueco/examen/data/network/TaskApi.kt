package com.pberrueco.examen.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TaskApi {
    //Parsea los Json a data class
    private val converter = GsonConverterFactory.create()

    //Asigna el nivel de detalle que queremos por consola de las peticiones
    private val logginIntercerptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    //Carga el Interceptor
    private val client = OkHttpClient.Builder().addInterceptor(logginIntercerptor).build()

    //Instancia de Retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://ud5-server.onrender.com/api/v1/")
        .client(client)
        .addConverterFactory(converter)
        .build()
    //Para Llamar a las peticiones de red del servicio
    val service: TaskService by lazy {
        retrofit.create(TaskService::class.java)
    }
}