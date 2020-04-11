package com.hardcodeflow.viewpagercards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class CardFragment : Fragment() {
    private var mCardView: CardView? = null
    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater, @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_adapter, container, false)
        mCardView = view.findViewById<View>(R.id.cardView) as CardView
        mCardView!!.setMaxCardElevation(
            mCardView!!.getCardElevation()
                    * CardAdapter.MAX_ELEVATION_FACTOR
        )
        return view
    }

    val cardView: CardView?
        get() = mCardView
}
