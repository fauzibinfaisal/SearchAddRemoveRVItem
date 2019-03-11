package com.fauzify.searchaddremovervitem.SearchAddRemoveSuggestion

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.fauzify.searchaddremovervitem.ItemModel
import com.fauzify.searchaddremovervitem.R
import com.fauzify.searchaddremovervitem.Utils.SearchHelper
import com.fauzify.searchaddremovervitem.Utils.afterTextChanged
import com.fauzify.searchaddremovervitem.Utils.invisible
import com.fauzify.searchaddremovervitem.Utils.visible
import kotlinx.android.synthetic.main.activity_search_add_remove_suggest.*

class SearchAddRemoveSuggestActivity : AppCompatActivity() {

    lateinit var adapter: SearchSuggestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_add_remove_suggest)

        rv_search_add_suggest.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        adapter = SearchSuggestAdapter(this, SearchHelper.loadItemList())
        rv_search_add_suggest.adapter = adapter

        et_search_add_remove_suggest.afterTextChanged {
            card_search_add_suggest.visible()
            searchFilter(it)
        }
    }

    fun searchFilter(text: String) {
        val filteredList: ArrayList<ItemModel> = ArrayList()
        val itemList: ArrayList<ItemModel> = SearchHelper.loadItemList()
        for (eachItem in itemList) {
            if (eachItem.title.toLowerCase().contains(text.toLowerCase()) || eachItem.desc.toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(eachItem)
            }
        }
        adapter.filterList(filteredList);
    }

    override fun onBackPressed() {
        if(et_search_add_remove_suggest.isFocused){
            layout_search_add_remove_suggest.requestFocus()
            card_search_add_suggest.invisible()
        }
        else{
            super.onBackPressed()
        }
    }

}
