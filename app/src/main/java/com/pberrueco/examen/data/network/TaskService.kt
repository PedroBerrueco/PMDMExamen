package com.pberrueco.examen.data.network

import com.pberrueco.examen.data.network.model.TaskResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface TaskService {

    @GET("task/{departament}")
    suspend fun getHomeWork(@Header("Authorization") userName: String, @Path("departament")departament: String) : Response<List<TaskResponse>>
}