package org.yxm.wanandroidclient.modules.series

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.yxm.wanandroidclient.R

class SeriesFragment : Fragment() {

    companion object {
        fun newInstance(): SeriesFragment {
            val args = Bundle()

            val fragment = SeriesFragment()
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.series_fragment, container, false)
    }

}