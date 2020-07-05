package com.example.android.databinding.basicsample.ui.testcase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.android.databinding.basicsample.databinding.TestItemBinding
import com.example.android.databinding.basicsample.ui.base.BaseAdapter
import com.example.android.databinding.basicsample.ui.base.BaseViewHolder

private val comparator = { old: String, new: String -> old.hashCode() == new.hashCode() }

class TestAdapter(private val callbacks: AdapterCallbacks) : BaseAdapter<String>(
        areItemsSame = comparator,
        areContentsSame = comparator
) {
    override fun createViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder<String> =
            TestItemViewHolder(TestItemBinding.inflate(layoutInflater, parent, false), callbacks)
}

