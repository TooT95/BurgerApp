package com.example.androidbasic.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidbasic.adapter.CategoryAdapter
import com.example.androidbasic.databinding.FragmentCategoryBinding
import com.example.androidbasic.model.Category
import com.example.androidbasic.viewmodel.CategoryListViewModel

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(FragmentCategoryBinding::inflate) {

    private val viewModel: CategoryListViewModel by viewModels()
    private val categoryAdapter: CategoryAdapter by lazy {
        CategoryAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        observeViewModel()
//        listOf(Category(name = "Бургеры"),Category(name = "Шаурма"),Category(name = "Лаваш")).forEach {
//            viewModel.insertCategory(it)
//        }
        viewModel.getCategoryList()
    }

    private fun observeViewModel() {
        viewModel.categoryListLiveData.observe(viewLifecycleOwner) {
            categoryAdapter.submitList(it)
        }
        viewModel.toastLiveData.observe(viewLifecycleOwner, ::toast)
    }

    private fun setupView() {
        binding.apply {
            rvMain.apply {
                adapter = categoryAdapter
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }
}