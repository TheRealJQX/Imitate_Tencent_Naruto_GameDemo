package com.example.slidedemo.Model

import com.example.slidedemo.R
import com.example.slidedemo.View.widget.Scroll

/**
 *名称:com.example.slidedemo.Model
 *描述:
 *编写者:JQX
 *编写时间:2019/4/4 18:18
 */
class RecyclerModel: IRecyclerModel {

    //初始化卷轴数据
    override fun initScroll(iLoad: ILoad) {
        var scrolls: ArrayList<Scroll> = ArrayList()
        var imageID: Int
        for(i in 1..2){
            imageID = R.drawable::class.java.getField("part$i").getInt(R.drawable())
            scrolls.add(Scroll("part$i",imageID))
        }
       iLoad.sendView(scrolls)
    }
}