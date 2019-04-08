package com.example.slidedemo.View.factory

import android.app.Activity
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.ViewGroup
import com.example.slidedemo.View.adapter.ScrollAdapter

import java.security.acl.Group
import android.R



/**
 *名称:com.example.slidedemo.View.factory
 *描述:
 *编写者:JQX
 *编写时间:2019/4/7 16:53
 */

class ScrollFactory{


  /*  companion object {
        fun getCurrentFragment(viewPager: ViewPager): NinjiaViewFragment? {
            if(viewPager.adapter is ScrollAdapter){
               var scrollAdapter =viewPager.adapter as ScrollAdapter
                var fragment = scrollAdapter.currentFragment
            if(fragment is NinjiaViewFragment)
                return fragment as NinjiaViewFragment
            }
            return null
        }
*/

    companion object {


        fun setupViewPager(viewPager: ViewPager) {
            var layoutParams = viewPager.layoutParams
            layoutParams.width = (viewPager.context as Activity).windowManager.defaultDisplay.width / 6
            layoutParams.height = (layoutParams.width *3.5 ).toInt()
            viewPager.offscreenPageLimit = 4
            viewPager.pageMargin = (layoutParams.width/2)
              if(viewPager.parent is ViewGroup){
                var viewParent = viewPager.parent as ViewGroup
                viewParent.clipChildren = false
                viewPager.clipChildren = false
            }

            viewPager.setPageTransformer(true, ViewPageTransform())
            Log.e("ScrollFactory", "CHECK")

        }

    }
    }
