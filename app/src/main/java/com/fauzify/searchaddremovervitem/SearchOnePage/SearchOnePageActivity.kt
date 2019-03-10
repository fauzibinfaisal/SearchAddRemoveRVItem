package com.fauzify.searchaddremovervitem.SearchOnePage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.fauzify.searchaddremovervitem.ItemModel
import com.fauzify.searchaddremovervitem.R
import com.fauzify.searchaddremovervitem.Utils.SearchHelper
import com.fauzify.searchaddremovervitem.Utils.afterTextChanged
import kotlinx.android.synthetic.main.activity_search_one_page.*

class SearchOnePageActivity : AppCompatActivity() {

    lateinit var adapter: SearchOnePageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_one_page)

        rv_search_one_page.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        adapter = SearchOnePageAdapter(this, SearchHelper.loadItemList())
        rv_search_one_page.adapter = adapter

        et_search_one_page.afterTextChanged {
            searchFilter(it)
        }
    }

    fun searchFilter(text: String) {

        val filteredList: ArrayList<ItemModel> = ArrayList()
        val itemList : ArrayList<ItemModel> = SearchHelper.loadItemList()

        for (eachItem in itemList) {
            if (eachItem.title.toLowerCase().contains(text.toLowerCase()) || eachItem.desc.toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(eachItem)
            }
        }

        adapter.filterList(filteredList);
    }
}
