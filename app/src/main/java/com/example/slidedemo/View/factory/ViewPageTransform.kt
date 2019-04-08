package com.example.slidedemo.View.factory

import android.os.Build
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View

/**
 *名称:com.example.slidedemo.View.factory
 *描述:
 *编写者:JQX
 *编写时间:2019/4/7 17:13
 */
const val MAX_SCALE = 0.8f
const val MIN_SCALE = 0.5f

class ViewPageTransform: ViewPager.PageTransformer {

    override fun transformPage(p0: View, p1: Float) {

        var position = p1
      //  Log.e("ViewPager",p1.toString())
        if(position<-3) position = -3f
        else if(position>3) position = -3f

        var setScale = if (position < 0)  position + 3 else  3-position


        var slope = (MAX_SCALE - MIN_SCALE)/3
        var scale = MIN_SCALE + setScale*slope



        p0.scaleX = scale
        p0.scaleY = scale

    }
}