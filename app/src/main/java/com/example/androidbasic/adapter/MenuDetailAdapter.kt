package com.example.androidbasic.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidbasic.R
import com.example.androidbasic.databinding.ItemMenuDetailBinding
import com.example.androidbasic.extension.inflateBind
import com.example.androidbasic.model.Product

class MenuDetailAdapter :
    ListAdapter<Product, MenuDetailAdapter.MenuDetailHolder>(MenuDetailDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MenuDetailHolder(
        parent.inflateBind(
            R.layout.item_menu_detail
        )
    )

    override fun onBindViewHolder(holder: MenuDetailHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount() = currentList.size

    class MenuDetailHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val itemBinding = ItemMenuDetailBinding.bind(view)

        fun bind(product: Product) {
            itemBinding.apply {
                txtProductName.text = product.name

                Glide.with(itemView)
                    .load(product.imageUrl)
                    .into(ivUrl)
            }
        }

    }

    class MenuDetailDiffUtil : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(
            oldItem: Product,
            newItem: Product
        ) = (oldItem.id == newItem.id)

        override fun areContentsTheSame(
            oldItem: Product,
            newItem: Product
        ) = (oldItem == newItem)

    }

}