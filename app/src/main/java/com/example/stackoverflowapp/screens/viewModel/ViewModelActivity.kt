package com.example.stackoverflowapp.screens.viewModel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.stackoverflowapp.R
import com.example.stackoverflowapp.screens.common.ScreensNavigator
import com.example.stackoverflowapp.screens.common.activities.BaseActivity
import com.example.stackoverflowapp.screens.common.toolbar.MyToolbar
import javax.inject.Inject

class ViewModelActivity : BaseActivity() {

    @Inject
    lateinit var screensNavigator: ScreensNavigator

    @Inject
    lateinit var myViewModel: MyViewModel

    private lateinit var toolbar: MyToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_view_model)

        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigateUpListener {
            screensNavigator.navigateBack()
        }

        myViewModel.questions.observe(this, Observer {
                questions -> Toast.makeText(this, "fetched ${questions.size} questions", Toast.LENGTH_SHORT).show()
        })
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ViewModelActivity::class.java)
            context.startActivity(intent)
        }
    }
}