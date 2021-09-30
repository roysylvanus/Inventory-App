package com.malinikali.inventory.interfaces

import androidx.room.*
import com.malinikali.inventory.models.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM item WHERE id = :id")
    fun getItem(id:Int) : Flow<Item>

    @Query("SELECT * FROM item ORDER BY name ASC")
    fun getAllItems() : Flow<List<Item>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item:Item)

    @Update
    suspend fun update(item:Item)

    @Delete
    suspend fun delete(item: Item)

}