package com.hardcodeflow.viewpagercards

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity(), View.OnClickListener,
        CompoundButton.OnCheckedChangeListener {


    private lateinit var mButton: Button
    private  lateinit var mViewPager: ViewPager

    private lateinit var mCardAdapter: CardPagerAdapter
    private lateinit  var mCardShadowTransformer: ShadowTransformer
    private lateinit var mFragmentCardAdapter: CardFragmentPagerAdapter
    private lateinit var mFragmentCardShadowTransformer: ShadowTransformer

    private var mShowingFragments = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewPager = findViewById(R.id.viewPager) as ViewPager
        mButton = findViewById(R.id.cardTypeBtn) as Button
        (findViewById(R.id.checkBox) as CheckBox).setOnCheckedChangeListener(this)
        mButton!!.setOnClickListener(this)
        mCardAdapter = CardPagerAdapter()

        mCardAdapter.addCardItem(CardItem(R.string.title_1, R.string.text_1))
        mCardAdapter.addCardItem(CardItem(R.string.title_2, R.string.text_1))
        mCardAdapter.addCardItem(CardItem(R.string.title_3, R.string.text_1))
        mCardAdapter.addCardItem(CardItem(R.string.title_4, R.string.text_1))
        mFragmentCardAdapter = CardFragmentPagerAdapter(supportFragmentManager,
                dpToPixels(2, this))
        mCardShadowTransformer = ShadowTransformer(mViewPager, mCardAdapter)
        mFragmentCardShadowTransformer = ShadowTransformer(mViewPager, mFragmentCardAdapter)
        mViewPager.setAdapter(mCardAdapter)
        mViewPager.setPageTransformer(false, mCardShadowTransformer)
        mViewPager.setOffscreenPageLimit(3)
    }

    override fun onClick(view: View?) {
        if (!mShowingFragments) {
            mButton!!.text = "Views"
            mViewPager.setAdapter(mFragmentCardAdapter)
            mViewPager.setPageTransformer(false, mFragmentCardShadowTransformer)
        } else {
            mButton!!.text = "Fragments"
            mViewPager.setAdapter(mCardAdapter)
            mViewPager.setPageTransformer(false, mCardShadowTransformer)
        }
        mShowingFragments = !mShowingFragments
    }

    fun dpToPixels(dp: Int, context: Context): Float {
        return dp * context.resources.displayMetrics.density
    }

    override fun onCheckedChanged(compoundButton: CompoundButton?, b: Boolean) {
        mCardShadowTransformer.enableScaling(b)
        mFragmentCardShadowTransformer.enableScaling(b)
    }
}
