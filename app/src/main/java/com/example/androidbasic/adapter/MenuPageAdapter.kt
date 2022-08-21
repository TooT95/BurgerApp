package com.example.androidbasic.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidbasic.fragment.AboutFragment
import com.example.androidbasic.fragment.CategoryFragment
import com.example.androidbasic.fragment.MenuFragment

class MenuPageAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 4

    companion object {
        const val PAGE_MENU = 0
        const val PAGE_CATEGORY = 1
        const val PAGE_ABOUT = 2
        const val PAGE_ACCOUNT = 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            PAGE_MENU -> MenuFragment()
            PAGE_CATEGORY -> CategoryFragment()
            PAGE_ABOUT -> AboutFragment()
            PAGE_ACCOUNT -> AboutFragment()
            else -> AboutFragment()
        }
    }
}