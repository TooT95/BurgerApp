package com.example.androidbasic.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidbasic.R
import com.example.androidbasic.databinding.ItemCategoryBinding
import com.example.androidbasic.extension.inflateBind
import com.example.androidbasic.model.Category

class CategoryAdapter : ListAdapter<Category, CategoryAdapter.CategoryHolder>(CategoryDiffUtil()) {

    override fun getItemCount() = currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        return CategoryHolder(parent.inflateBind(R.layout.item_category))
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class CategoryHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemCategoryBinding.bind(view)

        fun bind(category: Category) {
            binding.txtCategoryName.text = category.name
        }
    }

    class CategoryDiffUtil : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category) =
            (oldItem.id == newItem.id)

        override fun areContentsTheSame(oldItem: Category, newItem: Category) = (oldItem == newItem)

    }


}