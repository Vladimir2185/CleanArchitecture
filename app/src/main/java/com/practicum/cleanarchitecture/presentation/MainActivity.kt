package com.practicum.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import com.practicum.cleanarchitecture.R
import com.practicum.cleanarchitecture.domain.ShopItem
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var llShopList:LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel=ViewModelProvider(this)[MainViewModel::class.java]
        llShopList=ll_shop_list

        viewModel.shopList.observe(this){

            showList(it)
            //Log.i("test333","test11 "+it.toString())
        }
        //Log.i("present","test22 "+  viewModel.shopList)
    }
    private fun showList(list:List<ShopItem>){
        for (shopItem in list){
            val layoutID=if (shopItem.enabled)
            {R.layout.item_shop_enabled}
                else {R.layout.item_shop_desabled}
            val view=LayoutInflater.from(this).inflate(layoutID,llShopList,false)
            llShopList.addView(view)

        }
    }
}