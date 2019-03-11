package com.fauzify.searchaddremovervitem.SearchAddRemoveSuggestion

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fauzify.searchaddremovervitem.ItemModel
import com.fauzify.searchaddremovervitem.R
import kotlinx.android.synthetic.main.item_search_one_page.view.*

class SearchItemAdapter (val context : Context, var itemList: ArrayList<ItemModel>)
    : RecyclerView.Adapter<SearchItemAdapter.ViewHolder>() {

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.txtTitle?.text = itemList[position].title
        viewHolder.txtDesc?.text = itemList[position].desc
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_search_one_page, viewGroup, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle = itemView.tv_title
        val txtDesc = itemView.tv_desc
    }

    // To get the data to search Category
    fun filterList(filteredCourseList: ArrayList<ItemModel>) {
        this.itemList = filteredCourseList;
        notifyDataSetChanged();
    }
}