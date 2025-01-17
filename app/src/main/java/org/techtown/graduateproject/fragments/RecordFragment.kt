package org.techtown.graduateproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.techtown.graduateproject.R
import org.techtown.graduateproject.RecordPagerAdapter

class RecordFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_record, container, false)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        viewPager.isSaveEnabled = false;
        val pagerAdapter = RecordPagerAdapter(childFragmentManager, lifecycle)
        viewPager.adapter = pagerAdapter
        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            tab.text = if(position == 0) "전체 기록"
            else "히스토리"
        }.attach()

        return view
    }
}