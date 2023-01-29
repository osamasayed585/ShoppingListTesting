package com.usdroid.shoppinglisttesting.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingItemsDB : RoomDatabase() {
    abstract fun shoppingDao(): ShoppingDao
}