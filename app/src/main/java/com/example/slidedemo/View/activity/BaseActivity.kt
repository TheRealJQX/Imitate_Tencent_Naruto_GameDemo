package com.example.slidedemo.View.activity

import android.app.Activity
import android.support.v7.app.AppCompatActivity

/**
 *名称:com.example.slidedemo.View.activity
 *描述:
 *编写者:JQX
 *编写时间:2019/4/4 17:50
 */
abstract class BaseActivity: AppCompatActivity(){

    abstract fun initView()
    abstract fun setListeners()
    abstract fun getExtra()
}