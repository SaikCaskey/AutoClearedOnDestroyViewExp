package com.example.android.databinding.basicsample.ui.testcase.adapter

import com.example.android.databinding.basicsample.databinding.TestItemBinding
import com.example.android.databinding.basicsample.ui.base.BaseViewHolder

class TestItemViewHolder(private val binding: TestItemBinding,
                         private val callbacks: AdapterCallbacks
) : BaseViewHolder<String>(binding) {

    override fun bind(data: String, position: Int) {
        binding.content.text = data
        binding.root.setOnClickListener { callbacks.onItemClick(data) }
    }
}
