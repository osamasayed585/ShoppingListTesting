package com.usdroid.shoppinglisttesting.data.local

import androidx.room.Database

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingItemsDB {
    abstract fun shoppingDao(): ShoppingDao
}