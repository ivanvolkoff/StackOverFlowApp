package com.example.stackoverflowapp.screens.questionlist

import android.os.Bundle
import android.util.Log
import com.example.stackoverflowapp.R
import com.example.stackoverflowapp.screens.common.activities.BaseActivity
import com.example.stackoverflowapp.screens.common.viewMVC.ScreensNavigator
import javax.inject.Inject


class QuestionsListActivity : BaseActivity() {

    @Inject lateinit var screensNavigator: ScreensNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        Log.e("QuestionsListActivity","$screensNavigator")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_frame)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.layout_frame, QuestionsListFragment())
                .commit()
        }


    }


}


