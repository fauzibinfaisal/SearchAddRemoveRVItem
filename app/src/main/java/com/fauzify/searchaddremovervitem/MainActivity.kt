package com.fauzify.searchaddremovervitem

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.fauzify.searchaddremovervitem.SearchOnePage.SearchOnePageActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_search.setOnClickListener {
            startActivity(Intent(this, SearchOnePageActivity::class.java))
        }
    }
}
