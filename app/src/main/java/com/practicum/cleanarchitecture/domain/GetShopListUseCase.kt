package com.practicum.cleanarchitecture.domain

import android.util.Log
import androidx.lifecycle.LiveData
import com.practicum.cleanarchitecture.data.ShopListRepositoryImpl

class GetShopListUseCase(private  val shopListRepository: ShopListRepository) {


    fun getShopList(): LiveData<List<ShopItem>> {

        return shopListRepository.getShopList()
    }
}