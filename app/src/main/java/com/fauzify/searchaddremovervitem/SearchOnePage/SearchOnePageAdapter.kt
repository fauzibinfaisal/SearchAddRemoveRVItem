package com.fauzify.searchaddremovervitem.SearchOnePage

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fauzify.searchaddremovervitem.ItemModel
import com.fauzify.searchaddremovervitem.R
import kotlinx.android.synthetic.main.item_search_one_page.view.*

class SearchOnePageAdapter(val context : Context, var courseList: ArrayList<ItemModel>) : RecyclerView.Adapter<SearchOnePageAdapter.ViewHolder>() {

    override fun onBindViewHolder(viewHolder: ViewHolder, p1: Int) {
        viewHolder.txtTitle?.text = courseList[p1].title
        viewHolder.txtDesc?.text = courseList[p1].desc
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_search_one_page, viewGroup, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle = itemView.tv_title
        val txtDesc = itemView.tv_desc
    }

    // To get the data to search Category
    fun filterList(filteredCourseList: ArrayList<ItemModel>) {
        this.courseList = filteredCourseList;
        notifyDataSetChanged();
    }
}