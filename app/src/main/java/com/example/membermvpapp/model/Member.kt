package com.example.membermvpapp.model

class Member(
    val name: String,
    var age: Int,
    val location: String,
    val github: String,
    val position: String,
    var years_in_hipo: Int
) {
    override fun toString(): String {
        return "$name"
    }
}