package com.example.slidedemo.View.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.example.slidedemo.View.widget.Scroll

/**
 *名称:com.example.slidedemo.View.fragment
 *描述:
 *编写者:JQX
 *编写时间:2019/4/7 16:13
 */

class NinjiaPlotFragment: ScrollFragment() {
    private lateinit var scroll: Scroll


    companion object {
       private val KEY_SLIDE = "Scroll"

        @JvmStatic
        fun newInstance(scroll: Scroll): NinjiaPlotFragment{
           var fragment = NinjiaPlotFragment()
           var args = Bundle()
           args.putSerializable(KEY_SLIDE,scroll)
           fragment.arguments = args
            Log.e("NinjiaPlotFragment", "CHECK")

            return fragment
       }



   }

   /* override fun getFragment(): Fragment {
        return ScrollFragment.newInstance(scroll)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var args = arguments
        if(args != null){
            scroll = args.getSerializable(KEY_SLIDE) as Scroll
            Log.e("NinjiaPlot_onCreate", "CHECK")

        }
    }*/
}

