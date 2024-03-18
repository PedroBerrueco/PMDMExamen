package com.pberrueco.examen.data.network.model


import com.google.gson.annotations.SerializedName

data class Project(
    @SerializedName("department")
    val department: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("project_dead_line")
    val projectDeadLine: String,
    @SerializedName("project_photo")
    val projectPhoto: Any,
    @SerializedName("title")
    val title: String
)