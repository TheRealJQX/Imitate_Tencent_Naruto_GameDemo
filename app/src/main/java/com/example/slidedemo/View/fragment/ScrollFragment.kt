package com.example.slidedemo.View.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.slidedemo.R
import com.example.slidedemo.View.widget.Scroll
import kotlinx.android.synthetic.main.scroll_item.*
import org.jetbrains.anko.*
import java.io.Serializable

/**
 * 名称:com.example.slidedemo.View.fragment
 * 描述:
 * 编写者:JQX
 * 编写时间:2019/4/6 22:48
 */
open class ScrollFragment : Fragment(), Serializable {

    private var scroll: Scroll? = null
    private lateinit var imageView: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
        args?.getSerializable(KEY_SLIDE)
        if (args != null) {
            scroll = args.getSerializable(KEY_SLIDE) as Scroll
            Log.e("ScrollFM_onCreate", "CHECK")

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(scroll != null) {
            imageView = view.findViewById(R.id.image_scroll)
            imageView.setBackgroundResource(scroll!!.imgID)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        Log.e("ScrollFM_onCreateView", "CHECK")

        return inflater.inflate(R.layout.scroll_item,container,false)
    }

    companion object {

        private val KEY_SLIDE = "Scroll"


        fun newInstance(scroll: Scroll): ScrollFragment {
            val args = Bundle()
            val scrollFragment = ScrollFragment()
            args.putSerializable(KEY_SLIDE, scroll)
            scrollFragment.arguments = args
            Log.e("ScrollFM_newInstance", "CHECK")

            return scrollFragment
        }
    }
}
