package com.hardcodeflow.viewpagercards

import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import java.util.*


class CardFragmentPagerAdapter(fm: FragmentManager, baseElevation: Float) :
    FragmentStatePagerAdapter(fm), CardAdapter {
    private val mFragments: MutableList<CardFragment>
    override val baseElevation: Float

    override fun getCardViewAt(position: Int): CardView? {
        return mFragments[position].cardView
    }

    override val number: Int
        get() =mFragments.size



    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {

            return mFragments.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment: Any = super.instantiateItem(container, position)
        mFragments[position] = fragment as CardFragment
        return fragment
    }

    fun addCardFragment(fragment: CardFragment) {
        mFragments.add(fragment)
    }

    init {
        mFragments = ArrayList<CardFragment>()
        this.baseElevation = baseElevation
        for (i in 0..4) {
            addCardFragment(CardFragment())
        }
    }
}