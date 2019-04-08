package com.example.slidedemo.Presenter

import com.example.slidedemo.Model.ILoad
import com.example.slidedemo.Model.IRecyclerModel
import com.example.slidedemo.Model.RecyclerModel
import com.example.slidedemo.View.iview.IRecyclerView
import com.example.slidedemo.View.widget.Scroll

/**
 *名称:com.example.slidedemo.Presenter
 *描述:
 *编写者:JQX
 *编写时间:2019/4/4 17:27
 */


class RecyclerViewPresenter: IRecyclerViewPresenter, ILoad{

     private var iRecyclerView: IRecyclerView
     private var iRecyclerModel: IRecyclerModel

    constructor(iRecyclerView: IRecyclerView) {
        this.iRecyclerView = iRecyclerView
        this.iRecyclerModel = RecyclerModel()
    }

    override fun sendView(scrolls: ArrayList<Scroll>) {
        iRecyclerView.initRecyclerView(scrolls)
    }

    override fun getRecyclerData() {
        iRecyclerModel.initScroll(this)
    }
}