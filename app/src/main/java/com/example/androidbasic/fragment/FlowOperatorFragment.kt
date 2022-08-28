package com.example.androidbasic.fragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.androidbasic.databinding.FragmentFlowOperatorBinding
import com.example.androidbasic.extension.changedFlow
import com.example.androidbasic.extension.checkedChangesFlow
import com.example.androidbasic.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.Exception

class FlowOperatorFragment :
    BaseFragment<FragmentFlowOperatorBinding>(FragmentFlowOperatorBinding::inflate) {

    private val userList = listOf(
        User(1, "Javohir", 100, "male"),
        User(2, "Nana", 100, "female"),
        User(3, "Alexander", 100, "male"),
        User(4, "Eugene", 100, "male"),
        User(5, "Kira", 100, "female"),
        User(6, "Alex", 100, "male"),
        User(7, "Anna", 100, "female")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        errorHandling()
    }

    private fun flowOnCurrent() {
        viewLifecycleOwner.lifecycleScope.launch {
            flow {
                delay(1000)
                emit(1)
                delay(1000)
                emit(2)
            }.flowOn(Dispatchers.IO)
                .flowOn(Dispatchers.Main)
                .map { it * it }
                .flowOn(Dispatchers.IO)
                .collect {
                    binding.txtResult.text = it.toString()
                }


            combine(
                binding.etxtSearch.changedFlow().onStart { emit("") },
                binding.chbFemale.checkedChangesFlow().onStart { emit(false) }
            ) { text, onlyFemale ->
                text to onlyFemale
            }
                .debounce(500)
                .distinctUntilChanged()
                .onEach { showProgress(true) }
                .mapLatest { (text, onlyFemale) ->
                    searchUser(text, onlyFemale)
                }
                .onEach { showProgress(false) }
                .map { listUser ->
                    listUser.joinToString("\n") { it.toString() }
                }
                .collect {
                    binding.txtResult.text = it
                }
        }
    }

    private fun showProgress(show: Boolean) {
        binding.pbLoading.isVisible = show
    }

    private suspend fun searchUser(query: String, onlyFemale: Boolean): List<User> {
        delay(500)
        return userList.filter {
            it.name.contains(
                query,
                ignoreCase = true
            ) && (if (onlyFemale) it.gender.equals("female") else true)
        }
    }

    private fun errorHandling() {
        flow {
            delay(1000)
            throw IOException()
            emit(1)
        }
            .catch { emit(-1) }
            .catch { throw it }
            .map { it * 2 }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }
}