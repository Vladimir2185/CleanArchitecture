package com.practicum.cleanarchitecture.data

import com.practicum.cleanarchitecture.domain.ShopItem
import com.practicum.cleanarchitecture.domain.ShopListRepository

//object - singleton
object ShopListRepositoryImpl:ShopListRepository {
    private val shopList= mutableListOf<ShopItem>()
    private var autoIncrementedId=0

    override fun addShopItem(shopItem: ShopItem) {
        shopItem.id= autoIncrementedId++//+autoIncrementedId++ post increment
        shopList.add(shopItem)

    }

    override fun changeShopItem(shopItem: ShopItem) {
        shopList[shopItem.id]=shopItem
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()//return copy of shopList
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList[shopItemId]
    }
}