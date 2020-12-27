package org.yxm.wanandroidclient.modules.collection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.yxm.wanandroidclient.R

class CollectionFragment : Fragment() {

    companion object {
        fun newInstance(): CollectionFragment {
            val args = Bundle()

            val fragment = CollectionFragment()
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.collection_fragment, container, false)
    }

}