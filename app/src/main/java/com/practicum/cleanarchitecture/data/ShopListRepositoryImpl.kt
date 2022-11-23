package com.practicum.cleanarchitecture.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.practicum.cleanarchitecture.domain.ShopItem
import com.practicum.cleanarchitecture.domain.ShopListRepository

//object - singleton
//ShopListRepositoryImpl реализует интерфейс ShopListRepository
object ShopListRepositoryImpl:ShopListRepository {
    private val shopListLD= MutableLiveData<List<ShopItem>>()
    private val shopList= mutableListOf<ShopItem>()
    private var autoIncrementedId=0

    init{
        for ( i in 0 until 10){
        val shopItem=ShopItem("\n Bread$i",i+1)
        shopList.add(shopItem)

        }
    }


    override fun addShopItem(shopItem: ShopItem) {
        shopItem.id= autoIncrementedId++//+autoIncrementedId++ post increment
        shopList.add(shopItem)
        updateList()

    }

    override fun changeShopItem(shopItem: ShopItem) {
        shopList[shopItem.id]=shopItem
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun getShopList():LiveData<List<ShopItem>> {
        updateList()

        return shopListLD
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList[shopItemId]
    }

    private fun updateList()//заливаем в LIVE DATA
    {
        //set value из главного потока, post value из любого потока
        shopListLD.value= shopList.toList()//возвращаем копию листа вместо самого листа
    }
}