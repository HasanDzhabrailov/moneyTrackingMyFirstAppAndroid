package com.example.moneytracking.repository

import androidx.lifecycle.LiveData
import com.example.moneytracking.database.MoneyTrack
import com.example.moneytracking.database.MoneyTrackDatabaseDao

class MoneyRepository(private val moneyTrackDao: MoneyTrackDatabaseDao) {
	val allExpenses: LiveData<List<MoneyTrack>> = moneyTrackDao.getExpenses()

	suspend fun insert(expenses: MoneyTrack) {
		moneyTrackDao.insert(expenses)
	}
}