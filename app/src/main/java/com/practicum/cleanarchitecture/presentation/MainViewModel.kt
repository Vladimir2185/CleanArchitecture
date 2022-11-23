package com.practicum.cleanarchitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.practicum.cleanarchitecture.data.ShopListRepositoryImpl
import com.practicum.cleanarchitecture.domain.ChangeShopItemUseCase
import com.practicum.cleanarchitecture.domain.DeleteShopItemUseCase
import com.practicum.cleanarchitecture.domain.GetShopListUseCase
import com.practicum.cleanarchitecture.domain.ShopItem

class MainViewModel:ViewModel() //if context is needed ->AndroidViewModel, if not-> ViewModel
{
    private val repository=ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val changeShopItemUseCase = ChangeShopItemUseCase(repository)

    val shopList=getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)

    }

    fun changeEnableState(shopItem: ShopItem){
        val newItem=shopItem.copy(enabled = !shopItem.enabled)
        changeShopItemUseCase.changeShopItem(newItem)

    }

}