package com.fauzify.searchaddremovervitem.Utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.fauzify.searchaddremovervitem.ItemModel

class SearchHelper{
    companion object {
        fun <ArrayList> loadItemList(): ArrayList {
            val itemList = ArrayList<ItemModel>()
            itemList.add(ItemModel("item A", "desc for item A"))
            itemList.add(ItemModel("item B", "desc for item B"))
            itemList.add(ItemModel("item C", "desc for item C"))
            itemList.add(ItemModel("Fauzi", "Android Developer"))
            itemList.add(ItemModel("Fauzify", "fauzify.com"))
            itemList.add(ItemModel("Fauzi Github", "/fauzibinfaisal"))
            itemList.add(ItemModel("Fauzi Gitlab", "/fauzibinfaisal"))
            itemList.add(ItemModel("Kotlin Android Search View", "Tutorial Kotlin Search View"))
            itemList.add(ItemModel("Java Android Search View", "Tutorial Java Search View"))
            return itemList as ArrayList
        }
    }
}


fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}
