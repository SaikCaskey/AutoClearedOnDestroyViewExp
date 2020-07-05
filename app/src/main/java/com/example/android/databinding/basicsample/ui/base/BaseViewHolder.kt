package com.example.android.databinding.basicsample.ui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<in T>(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(data: T, position: Int)
}
