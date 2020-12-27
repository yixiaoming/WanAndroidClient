package org.yxm.wanandroidclient.modules.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import kotlinx.android.synthetic.main.activity_main.*
import org.yxm.wanandroidclient.modules.collection.CollectionFragment
import org.yxm.wanandroidclient.modules.mainpage.MainPageFragment
import org.yxm.wanandroidclient.modules.personal.PersonalFragment
import org.yxm.wanandroidclient.modules.series.SeriesFragment
import org.yxm.wanandroidclient.R
import java.lang.RuntimeException


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private val TAG = "MainActivity"
    private val PERSONAL_FRAGMENT: String = "personal_fragment"
    private val COLLECTION_FRAGMENT: String = "collection_fragment"
    private val SERIES_FRAGMENT: String = "series_fragment"
    private val MAIN_PAGE_FRAGMENT: String = "main_page_fragment"
    private var mLastFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation_view.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
        navigation_view.setOnNavigationItemSelectedListener(this)
        showFragment(MAIN_PAGE_FRAGMENT)

        var map = HashMap<String, String>()
        map.put("1", "2")
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d(TAG, "onNavigationItemSelected: ${item.itemId}")
        when (item.itemId) {
            R.id.main_page -> showFragment(MAIN_PAGE_FRAGMENT)
            R.id.series -> showFragment(SERIES_FRAGMENT)
            R.id.collection -> showFragment(COLLECTION_FRAGMENT)
            R.id.personal -> showFragment(PERSONAL_FRAGMENT)
        }
        return true
    }

    private fun showFragment(fragmentTag: String) {
        Log.d(TAG, "showFragment: $fragmentTag")
        var targetFragment = supportFragmentManager.findFragmentByTag(fragmentTag)
        if (targetFragment == null) {
            val createFragment = when (fragmentTag) {
                MAIN_PAGE_FRAGMENT -> MainPageFragment.newInstance()
                SERIES_FRAGMENT -> SeriesFragment.newInstance()
                COLLECTION_FRAGMENT -> CollectionFragment.newInstance()
                PERSONAL_FRAGMENT -> PersonalFragment.newInstance()
                else -> throw RuntimeException("not found fragment!")
            }
            supportFragmentManager.beginTransaction()
                .add(R.id.main_content, createFragment, fragmentTag).commit()
            targetFragment = createFragment
        }

        supportFragmentManager.commit {
            mLastFragment?.let {
                Log.d(TAG, "hide: $mLastFragment")
                hide(mLastFragment!!)
            }
            show(targetFragment)
            mLastFragment = targetFragment
        }
    }
}