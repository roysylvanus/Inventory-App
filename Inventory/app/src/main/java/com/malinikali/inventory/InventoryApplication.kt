package com.malinikali.inventory

import android.app.Application
import com.malinikali.inventory.database.ItemRoomDatabase

class InventoryApplication : Application() {
    val  itemDatabase: ItemRoomDatabase by lazy {ItemRoomDatabase.getDatabase(this)}
}