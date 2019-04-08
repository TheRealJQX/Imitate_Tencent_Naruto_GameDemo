package com.example.slidedemo.View.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;
import com.example.slidedemo.View.fragment.NinjiaPlotFragment;
import com.example.slidedemo.View.widget.Scroll;


import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 名称:com.example.slidedemo.View.adapter
 * 描述:
 * 编写者:JQX
 * 编写时间:2019/4/6 22:34
 */
public class ScrollAdapter extends FragmentStatePagerAdapter {

    private List<Scroll> scrolls;
    WeakReference<Fragment> currentFragmentReference; //当前fragment弱引用

    public Fragment getCurrentFragment(){
        if(currentFragmentReference != null)
            return currentFragmentReference.get();
        return null;
    }

    public ScrollAdapter(FragmentManager fm) {
        super(fm);
        scrolls = new ArrayList<>();
    }

    public void  addAll(List<Scroll> scrolls){
        this.scrolls.addAll(scrolls);
        notifyDataSetChanged();//该方法由应用程序在适配器数据改变时主动调用。
    }

    @Override
    public Fragment getItem(int i) {

        Scroll scroll = scrolls.get(i);
        Log.e("Adapter","CHECK");
        return NinjiaPlotFragment.newInstance(scroll);
    }

    @Override
    public int getCount() {
        return scrolls.size();
    }

    /**
     * 告诉adapter,显示哪个Fragment页面
     * 调用该方法去通知当前适配器的哪一项被考虑为“primary”，它是当前展示给用户的页面。
     */
    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.setPrimaryItem(container, position, object);
        if(getCurrentFragment() != object){
            currentFragmentReference = new WeakReference<>((Fragment) object);
        }
        Log.e("setPrimaryItem","getItem");

    }
}
