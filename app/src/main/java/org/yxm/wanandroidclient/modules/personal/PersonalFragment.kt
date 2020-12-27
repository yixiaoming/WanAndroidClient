package org.yxm.wanandroidclient.modules.personal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.yxm.wanandroidclient.R

class PersonalFragment : Fragment() {

    companion object {
        fun newInstance(): PersonalFragment {
            val args = Bundle()

            val fragment = PersonalFragment()
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.personal_fragment, container, false)
    }

}