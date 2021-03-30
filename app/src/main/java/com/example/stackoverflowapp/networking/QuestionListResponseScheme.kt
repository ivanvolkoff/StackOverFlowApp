package com.example.stackoverflowapp.networking

import com.example.stackoverflowapp.questions.Question
import com.google.gson.annotations.SerializedName

class QuestionsListResponseSchema(@SerializedName("items") val questions: List<Question>)