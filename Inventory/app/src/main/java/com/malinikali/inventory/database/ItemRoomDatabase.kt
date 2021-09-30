package com.malinikali.inventory.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.malinikali.inventory.interfaces.ItemDao
import com.malinikali.inventory.models.Item

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ItemRoomDatabase:RoomDatabase() {

    abstract fun itemDao() :ItemDao

    companion object{
        @Volatile
        private var INSTANCE:ItemRoomDatabase? = null

        fun getDatabase(context: Context):ItemRoomDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemRoomDatabase::class.java,
                    "item_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }

    }
}