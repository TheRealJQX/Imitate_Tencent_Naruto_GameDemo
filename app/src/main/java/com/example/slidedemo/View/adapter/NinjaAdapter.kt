package com.example.slidedemo.View.adapter

import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.slidedemo.R
import com.example.slidedemo.View.holder.NinjiaHolder
import com.example.slidedemo.View.widget.Scroll
import kotlinx.android.synthetic.main.scroll_item.*

/**
 *名称:com.example.slidedemo.View.adapter
 *描述: 适配器准备
 *编写者:JQX
 *编写时间:2019/4/4 14:20
 */


class NinjaAdapter(scrollList: List<Scroll>) : RecyclerView.Adapter<NinjaAdapter.Companion.NinjiaViewHolder>() {

    private var scrolls: List<Scroll> = scrollList

      companion object {
          /** 通常传入的view参数是RecyclerView的子项最外层布局，
          *   从而可以用findViewById()获取实例
          */
         class NinjiaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
           var imageView: ImageView = itemView.findViewById(R.id.image_scroll)
         }
    }

    //创建ViewHolder实例
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NinjiaViewHolder {
        var view = LayoutInflater.from(p0.context).inflate(R.layout.scroll_item,p0,false)
        var ninjiaholder = NinjiaViewHolder(view)
        return ninjiaholder
        }

    //子项滚动到屏幕内时处理子项数据
  override fun onBindViewHolder(p0: NinjiaViewHolder, p1: Int) {
        var scroll = scrolls[p1]
        p0.imageView.setImageResource(scroll.imgID)
    }

    //子项数
    override fun getItemCount(): Int {
        return scrolls.size
    }




}