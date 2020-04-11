package com.hardcodeflow.viewpagercards

class CardItem(var mTitleResource: Int, var mTextResource: Int) {

    fun getText(): Int {
        return mTextResource
    }

    fun getTitle(): Int {
        return mTitleResource
    }
}