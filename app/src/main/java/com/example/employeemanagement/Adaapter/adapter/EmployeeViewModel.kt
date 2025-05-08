package com.example.employeemanagement.Adaapter.adapter

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.employeemanagement.Adaapter.model.EmplyeeInfo
import com.example.employeemanagement.Retrofit.RetrofitClient

class EmployeeViewModel : ViewModel() {

    val employeeList = MutableLiveData<List<EmplyeeInfo>>()

    suspend fun fetchEmployees() {
        try {
            val response = RetrofitClient.instance.getAllEmployees()
            if (response.isSuccessful && response.body() != null) {
                employeeList.postValue(response.body()!!.data)
            } else {
                // Handle API error
                Log.e("API_ERROR", "Response failed: ${response.code()}")
            }
        } catch (e: Exception) {
            Log.e("API_ERROR", "Exception: ${e.message}")
        }
    }
}