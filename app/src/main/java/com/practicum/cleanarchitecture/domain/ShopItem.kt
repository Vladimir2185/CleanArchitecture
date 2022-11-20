package com.practicum.cleanarchitecture.domain

data class ShopItem(var name:String,var count:Int=1,var enabled: Boolean =true,var id:Int= UNDEFINED_ID) {

    companion object {const val UNDEFINED_ID=-1}
}