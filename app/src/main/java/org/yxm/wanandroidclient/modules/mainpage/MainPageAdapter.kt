package org.yxm.wanandroidclient.modules.mainpage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.main_page_recycler_item.*
import org.yxm.wanandroidclient.network.entity.WanDataItem
import org.yxm.wanandroidclient.R
import java.text.SimpleDateFormat
import java.util.*

class MainPageAdapter : RecyclerView.Adapter<MainPageViewHolder>() {

    private val datas: MutableList<WanDataItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainPageViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.main_page_recycler_item, parent, false)
        return MainPageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: MainPageViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    fun addItems(items: List<WanDataItem>) {
        datas.addAll(items)
        notifyDataSetChanged()
    }
}

class MainPageViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(wanDataItem: WanDataItem) {
        itemTitle.text = wanDataItem.title
        if (wanDataItem.author.isNotEmpty()) {
            itemAuthor.text = wanDataItem.author
        }
        if (wanDataItem.publishTime > 0) {
            itemPublisTime.text = SimpleDateFormat("YYYY-mm-DD").format(Date(wanDataItem.publishTime))
        }
    }
}