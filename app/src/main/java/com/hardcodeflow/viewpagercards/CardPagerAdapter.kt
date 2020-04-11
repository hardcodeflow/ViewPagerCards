package com.hardcodeflow.viewpagercards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.PagerAdapter
import com.hardcodeflow.viewpagercards.CardAdapter.Companion.MAX_ELEVATION_FACTOR
import java.util.*

class CardPagerAdapter: PagerAdapter(), CardAdapter{


    private  var mViews: MutableList<CardView?>
    private var mData: MutableList<CardItem>
    private var mBaseElevation = 0f

    init {
        mData = ArrayList<CardItem>()
        mViews = ArrayList<CardView?>()
    }

    fun addCardItem(item: CardItem) {
        mViews!!.add(null)
        mData!!.add(item)
    }

    override val baseElevation: Float
        get() = mBaseElevation
    /*  override fun getBaseElevation(): Float {
        return mBaseElevation
    }

    override val baseElevation: Float
        get() = mData!!.size.toFloat()
*/


    override fun getCardViewAt(position: Int): CardView? {
        if(mViews.size>position) {
            return mViews!![position]
        }else{

            return null
        }
    }

    override val number: Int
        get() = 12

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return 0
         }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context)
            .inflate(R.layout.adapter, container, false)
        container.addView(view)
        bind(mData!![position], view)
        val cardView: CardView = view.findViewById<View>(R.id.cardView) as CardView
        if (mBaseElevation == 0f) {
            mBaseElevation = cardView.getCardElevation()
        }
        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR)
        mViews!![position] = cardView
        return view
    }

    override fun destroyItem(container: View, position: Int, `object`: Any) {
       // container.removeView(`object` as View?)
        mViews!![position] = null
    }

    private fun bind(item: CardItem, view: View) {
        val titleTextView =
            view.findViewById<View>(R.id.titleTextView) as TextView
        val contentTextView =
            view.findViewById<View>(R.id.contentTextView) as TextView
        titleTextView.setText(item.getTitle())
        contentTextView.setText(item.getText())
    }

}