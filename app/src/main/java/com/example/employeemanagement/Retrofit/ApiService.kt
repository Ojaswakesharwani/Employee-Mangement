package com.example.employeemanagement.Retrofit

import com.example.employeemanagement.Adaapter.model.EmployeeResponse
import com.example.employeemanagement.Adaapter.model.EmplyeeInfo
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("employees")
    suspend fun getAllEmployees(): Response<EmployeeResponse>
}