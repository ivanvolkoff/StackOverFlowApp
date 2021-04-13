package com.example.stackoverflowapp.screens.questiondetails

import android.content.Context
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.stackoverflowapp.R
import com.example.stackoverflowapp.screens.common.imageloader.ImageLoader
import com.example.stackoverflowapp.screens.common.toolbar.MyToolbar
import com.techyourchance.dagger2course.questions.QuestionWithBody

class QuestionDetailsViewMvc(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader,
    private val parent: ViewGroup?
) {
    interface Listener {
        fun onBackClicked()
    }

    private lateinit var toolbar: MyToolbar
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var txtQuestionBody: TextView
    private lateinit var user_image: ImageView
    private lateinit var user_name: TextView

    val rootView = layoutInflater.inflate(R.layout.layout_question_details, parent, false)
    private val context: Context get() = rootView.context

    var listeners = HashSet<Listener>()

    init {
        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigateUpListener {
            for (listener in listeners) {
                listener.onBackClicked()
            }
        }
        txtQuestionBody = findViewById(R.id.txt_question_body)
        user_image = findViewById(R.id.user_image)
        user_name = findViewById(R.id.user_name)
        swipeRefresh = findViewById(R.id.swipeRefresh)
        swipeRefresh.isEnabled = false
    }

    fun bindQuestionBody(question: QuestionWithBody) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtQuestionBody.text = Html.fromHtml(question.body, Html.FROM_HTML_MODE_LEGACY)
            user_name.text = Html.fromHtml(question.owner.name,Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            txtQuestionBody.text = Html.fromHtml(question.body)
            user_name.text = Html.fromHtml(question.owner.name,Html.FROM_HTML_MODE_LEGACY)
        }
        imageLoader.loadImage(question.owner.imageURL,user_image)
    }

    private fun <T : View?> findViewById(@IdRes id: Int): T {
        return rootView.findViewById<T>(id)
    }

    fun registerListener(listener: Listener) {
        listeners.add(listener)
    }

    fun unregisterListener(listener: Listener) {
        listeners.remove(listener)
    }

    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        if (swipeRefresh.isRefreshing) {
            swipeRefresh.isRefreshing = false
        }
    }
}