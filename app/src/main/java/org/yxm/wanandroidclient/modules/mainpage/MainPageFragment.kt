package org.yxm.wanandroidclient.modules.mainpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_page_fragment.*
import org.xiao.ui.loadmore.LoadMoreRecyclerView
import org.yxm.wanandroidclient.R

class MainPageFragment : Fragment() {
    private val mainPageViewModel: MainPageViewModel by viewModels()

    companion object {
        fun newInstance(): MainPageFragment {
            val args = Bundle()
            val fragment = MainPageFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_page_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview.adapter = MainPageAdapter()
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.setLoadMoreEnable(true)
        mainPageViewModel.loadMoreItems.observe(
            viewLifecycleOwner,
        ) { items ->
            if (items.isNotEmpty()) {
                ((recyclerview.adapter as LoadMoreRecyclerView.WrapAdapter).adapter as MainPageAdapter).addItems(
                    items
                )
                Toast.makeText(context, "add items:" + items.count(), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "没有更多内容了!!!", Toast.LENGTH_SHORT).show()
            }
            recyclerview.setLoadMoreComplete()
        }
        recyclerview.setLoadMoreListener(object : LoadMoreRecyclerView.LoadMoreListener {
            override fun onLoadMore() {
                mainPageViewModel.loadMore()
            }
        })
        mainPageViewModel.loadMore()
    }
}