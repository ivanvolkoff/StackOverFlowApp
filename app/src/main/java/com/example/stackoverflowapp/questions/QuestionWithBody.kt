package com.techyourchance.dagger2course.questions

import com.example.stackoverflowapp.users.Users
import com.google.gson.annotations.SerializedName

data class QuestionWithBody(
    @SerializedName("owner") val owner: Users,
    @SerializedName("title") val title: String,
    @SerializedName("question_id") val id: String,
    @SerializedName("body") val body: String
)