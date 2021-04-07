package com.example.stackoverflowapp.screens.questionlist

import android.os.Bundle
import com.example.stackoverflowapp.R
import com.example.stackoverflowapp.screens.common.activities.BaseActivity

class QuestionsListActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_frame)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.layout_frame, QuestionsListFragment())
                .commit()
        }


    }


}


