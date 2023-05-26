package com.usdroid.shoppinglisttesting.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    @Delete
    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)


    /**   why we don't use suspend for this function, and the reason for that?
     *    since this returns a livedata object we don't need that or this wouldn't work
     *    with room since livedata is already asynchronous by default
     *    so whenever you return live data with room then you don't want to make that a suspend function
     * */
    @Query("SELECT * FROM shopping_items")
    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    @Query("SELECT SUM(price * amount) FROM shopping_items")
    fun observeTotalPrice(): LiveData<Float>

}