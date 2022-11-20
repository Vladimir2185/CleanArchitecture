package com.practicum.cleanarchitecture.domain

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem){}
    fun changeShopItem(shopItem: ShopItem){}
    fun deleteShopItem(shopItem: ShopItem){}
    fun getShopList():List<ShopItem>{
        TODO()
    }
    fun getShopItem(shopItemId: Int):ShopItem{
        TODO()
    }
}