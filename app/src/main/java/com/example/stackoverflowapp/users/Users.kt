package com.example.stackoverflowapp.users

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("display_name")val name :String,
    @SerializedName("profile_image") val imageURL: String
)