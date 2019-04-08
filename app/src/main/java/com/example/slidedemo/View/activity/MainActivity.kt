package com.example.slidedemo.View.activity

import android.annotation.TargetApi
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.transition.Explode
import com.example.slidedemo.Model.ILoad
import com.example.slidedemo.Presenter.RecyclerViewPresenter
import com.example.slidedemo.R
import com.example.slidedemo.View.adapter.NinjaAdapter
import com.example.slidedemo.View.adapter.ScrollAdapter
import com.example.slidedemo.View.factory.ScrollFactory
import com.example.slidedemo.View.iview.IRecyclerView
import com.example.slidedemo.View.widget.Scroll

class MainActivity: BaseActivity(), IRecyclerView {

    private lateinit var recyclerViewPresenter: RecyclerViewPresenter
    private lateinit var viewPager: ViewPager

    override fun initRecyclerView(scrolls: List<Scroll>) {
        var recyclerView = findViewById<RecyclerView>(R.id.rv_scrolls)
        var adapter = NinjaAdapter(scrolls)
        var linearLayoutManager = LinearLayoutManager(this)

        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       /* recyclerViewPresenter = RecyclerViewPresenter(this)
        recyclerViewPresenter.getRecyclerData()*/
        setupWindoAnimations()
        initView()
        initAdapter(initScroll())
        setListeners()

    }
    fun initScroll(): ArrayList<Scroll> {
        var scrolls: ArrayList<Scroll> = ArrayList()
        var imageID: Int
        for(i in 1..7){
            imageID = R.drawable::class.java.getField("part$i").getInt(R.drawable())
            scrolls.add(Scroll("part$i",imageID))
        }
       return scrolls
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun setupWindoAnimations() {
        var slid = Explode()
        window.reenterTransition = slid
        window.exitTransition = slid
    }

    private fun initAdapter(scrolls: List<Scroll>){
        var scrollAdapter: ScrollAdapter = ScrollAdapter(getSupportFragmentManager())
        scrollAdapter.addAll(scrolls)
        viewPager.adapter = scrollAdapter
       ScrollFactory.setupViewPager(viewPager)
    }

    override fun initView() {
        viewPager = findViewById(R.id.vp_plot)
    }

    override fun setListeners() {
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {}

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    override fun getExtra() {
    }
}
