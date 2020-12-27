package org.yxm.wanandroidclient.modules.mainpage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.yxm.wanandroidclient.network.RetrofitManager
import org.yxm.wanandroidclient.network.entity.WanDataItem

class MainPageViewModel : ViewModel() {

    private var curPage = 0

    val loadMoreItems: MutableLiveData<List<WanDataItem>> by lazy {
        MutableLiveData<List<WanDataItem>>()
    }

    fun loadMore() {
        viewModelScope.launch {
            val content = RetrofitManager.wanApi().getMainPage(curPage)
            if (content.errorCode == 0) {
                curPage++
                loadMoreItems.value = content.data.datas
            }
        }
    }
}