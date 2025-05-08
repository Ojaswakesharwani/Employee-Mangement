package com.example.employeemanagement.Adaapter.model

import com.google.gson.annotations.SerializedName

data class EmplyeeInfo(
    var id : Int,
    @SerializedName("employee_name")
    val name: String,

    @SerializedName("employee_salary")
    val salary: Int,

    @SerializedName("employee_age")
    val age: Int,

    @SerializedName("profile_image")
    val image: String
)
