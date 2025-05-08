package com.example.employeemanagement.Adaapter.model

import com.google.gson.annotations.SerializedName

data class EmplyeeInfo(
    var id : Int,
    var name : String,
    var salary : Long,
    var age :Int,
    var profile :Int
)
