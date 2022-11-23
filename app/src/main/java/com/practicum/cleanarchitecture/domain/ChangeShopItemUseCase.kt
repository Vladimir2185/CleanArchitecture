package com.practicum.cleanarchitecture.domain

class ChangeShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun changeShopItem(shopItem: ShopItem){
        shopListRepository.changeShopItem(shopItem )
    }
}