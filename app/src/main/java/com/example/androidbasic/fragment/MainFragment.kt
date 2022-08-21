package com.example.androidbasic.fragment

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.androidbasic.R
import com.example.androidbasic.adapter.MenuPageAdapter
import com.example.androidbasic.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewPager.apply {
                adapter = MenuPageAdapter(requireActivity())
            }
            TabLayoutMediator(tabMain, viewPager) { tab, position ->
                when (position) {
                    MenuPageAdapter.PAGE_MENU -> {
                        tab.setText(R.string.tab_text_main)
                        tab.setIcon(R.drawable.ic_menu)
                    }
                    MenuPageAdapter.PAGE_CATEGORY -> {
                        tab.setText(R.string.tab_text_category)
                        tab.setIcon(R.drawable.ic_category)
                    }
                    MenuPageAdapter.PAGE_ABOUT -> {
                        tab.setText(R.string.tab_text_about)
                        tab.setIcon(R.drawable.ic_about)
                    }
                    MenuPageAdapter.PAGE_ACCOUNT -> {
                        tab.setText(R.string.tab_text_account)
                        tab.setIcon(R.drawable.ic_account)
                        tab.orCreateBadge.number = 1
                    }
                }
            }.attach()
            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    tabMain.getTabAt(position)?.removeBadge()
                }
            })
        }
    }

}