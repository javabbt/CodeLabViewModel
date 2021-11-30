package com.example.codelabviewmodel.application

import android.app.Application
import com.example.codelabviewmodel.database.WordRepository
import com.example.codelabviewmodel.database.WordRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { WordRoomDatabase.getDatabase(this , applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }
}