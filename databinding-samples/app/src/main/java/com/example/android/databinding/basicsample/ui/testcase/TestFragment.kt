package com.example.android.databinding.basicsample.ui.testcase

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.databinding.basicsample.R
import com.example.android.databinding.basicsample.data.TestViewModel
import com.example.android.databinding.basicsample.databinding.FragmentTestFragmentBinding
import com.example.android.databinding.basicsample.extensions.observe
import com.example.android.databinding.basicsample.ui.base.BaseFragment
import com.example.android.databinding.basicsample.ui.testcase.adapter.AdapterCallbacks
import com.example.android.databinding.basicsample.ui.testcase.adapter.TestAdapter

class TestFragment : BaseFragment<FragmentTestFragmentBinding>() {

    // region Properties

    private val testLayoutManager by lazy { LinearLayoutManager(context) }

    private val testAdapter by lazy { TestAdapter(callbacks) }

    private val testRecycler by lazy { binding.list }

    private val viewModel by viewModels<TestViewModel> { defaultViewModelProviderFactory }

    private val callbacks by lazy {
        AdapterCallbacks(
                /**
                 * Just do an action that will call onDestroyView
                 */
                onItemClick = { navController.navigate(R.id.action_testFragment_self) }
        )
    }

    // endregion Properties

    // region Functions

    override fun getLayoutId(): Int = R.layout.fragment_test_fragment

    override fun onDestroyView() {
        // FIXME Do anything here with binding object
        // This case is actually less important but is not unlike things we would like to be doing
        testRecycler.recycledViewPool
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpTestRecycler()
        viewModel.fetchListItems()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setUpTestRecycler() {
        with(binding.list) {
            layoutManager = testLayoutManager
            adapter = testAdapter
        }
        observe(viewModel.listItemsLiveData, testAdapter::submitList)
    }

    // endregion Functions

}