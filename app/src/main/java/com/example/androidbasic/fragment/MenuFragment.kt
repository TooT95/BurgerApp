package com.example.androidbasic.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidbasic.adapter.MenuAdapter
import com.example.androidbasic.databinding.FragmentMenuBinding
import com.example.androidbasic.viewmodel.MenuViewModel

class MenuFragment : BaseFragment<FragmentMenuBinding>(FragmentMenuBinding::inflate) {

    private val menuAdapter: MenuAdapter by lazy {
        MenuAdapter(requireContext())
    }
    private val viewModel: MenuViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModels()
        viewModel.getProductWithRelations()
//        listOf(
//            Product(
//                0,
//                "Гамбургер",
//                1,
//                20000f,
//                "https://cp.ectn.uz/files//0622/gamburger_evos.png",
//                "Мягкая булочка, сочная котлета из говядины, маринованные огурцы, свежие помидоры, красный лук и хрустящий салат айсберг, с двумя фирменными соусами"
//            ), Product(
//                0,
//                "Шаурма с говядиной Мини",
//                2,
//                20000f,
//                "https://cp.ectn.uz/files//0622/shaurma_s_govyadinoy_sredniy_evos.png",
//                "Сочная говядина, свежие огурцы и помидоры, хрустящие чипсы и наш фирменный томатный соус в горячей булке"
//            ), Product(
//                0,
//                "Лаваш с говядиной",
//                3,
//                20000f,
//                "https://cp.ectn.uz/files//0622/lavash_s_govyadinoy_evos.png",
//                "Сочная говядина завернута в лаваш с хрустящими чипсами, свежими огурцами и помидорами, с нашим фирменным томатным соусом"
//            )
//        ).forEach {
//            viewModel.insertProduct(it)
//        }
        setupView()
    }

    private fun setupView() {
        binding.rvMenu.apply {
            adapter = menuAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeViewModels() {
        viewModel.categoryListLiveData.observe(viewLifecycleOwner) {
            menuAdapter.submitList(it)
        }
        viewModel.toastLiveData.observe(viewLifecycleOwner, ::toast)
    }

}