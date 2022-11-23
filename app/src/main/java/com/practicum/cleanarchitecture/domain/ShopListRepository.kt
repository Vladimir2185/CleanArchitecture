package com.practicum.cleanarchitecture.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem){}
    fun changeShopItem(shopItem: ShopItem){}
    fun deleteShopItem(shopItem: ShopItem){}
    fun getShopList(): LiveData<List<ShopItem>>
    fun getShopItem(shopItemId: Int):ShopItem{
        TODO()
    }
}