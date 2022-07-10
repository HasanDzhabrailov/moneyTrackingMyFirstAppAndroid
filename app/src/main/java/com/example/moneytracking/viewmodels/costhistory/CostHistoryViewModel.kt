package com.example.moneytracking.viewmodels.costhistory

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.moneytracking.database.MoneyTrack
import com.example.moneytracking.database.MoneyTrackDatabaseDao
import com.example.moneytracking.formatMoney
import com.example.moneytracking.repository.MoneyRepository

class CostHistoryViewModel (dataSource: MoneyTrackDatabaseDao) :
	ViewModel() {
	val database = dataSource
	private val repository: MoneyRepository = MoneyRepository(database)

	 val allExpenses: LiveData<List<MoneyTrack>> = repository.allExpenses


}