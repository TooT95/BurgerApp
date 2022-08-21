package com.example.androidbasic.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidbasic.R
import com.example.androidbasic.databinding.ItemMenuBinding
import com.example.androidbasic.extension.inflateBind
import com.example.androidbasic.model.withrelations.ProductWithRelations


class MenuAdapter(private val context: Context) :
    ListAdapter<ProductWithRelations, MenuAdapter.MenuHolder>(MenuDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MenuHolder(
        context,
        parent.inflateBind(
            R.layout.item_menu
        )
    )

    override fun onBindViewHolder(holder: MenuHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount() = currentList.size

    class MenuHolder(private val context: Context, view: View) : RecyclerView.ViewHolder(view) {

        private val itemBinding = ItemMenuBinding.bind(view)

        fun bind(productWithRelations: ProductWithRelations) {
            itemBinding.apply {
                txtCategoryName.text = productWithRelations.category.name

                rvDetailMenu.apply {
                    adapter = MenuDetailAdapter().apply {
                        submitList(productWithRelations.productList)
                    }
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context).apply {
                        orientation = LinearLayoutManager.HORIZONTAL
                    }
                }
            }
        }

    }

    class MenuDiffUtil : DiffUtil.ItemCallback<ProductWithRelations>() {
        override fun areItemsTheSame(
            oldItem: ProductWithRelations,
            newItem: ProductWithRelations
        ) = (oldItem.category.id == newItem.category.id)

        override fun areContentsTheSame(
            oldItem: ProductWithRelations,
            newItem: ProductWithRelations
        ) = (oldItem == newItem)

    }

}