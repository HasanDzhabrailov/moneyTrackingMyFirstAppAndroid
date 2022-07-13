package com.example.moneytracking.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import org.jetbrains.annotations.NotNull

@Dao
interface MoneyTrackDatabaseDao {
	@Insert(onConflict = OnConflictStrategy.IGNORE)
	suspend fun insert(expensive: MoneyTrack)

	@Query("SELECT * from daily_money_expenses_table ORDER BY date_expense DESC")
	fun getExpenses(): LiveData<List<MoneyTrack>>

	@Query("SELECT SUM(sum_expense) from daily_money_expenses_table")
	 fun getSum():LiveData<Long>

	@Query("SELECT SUM(sum_expense) from daily_money_expenses_table WHERE  date_expense BETWEEN :startPeriod AND :endPeriod  ")
	fun getSumPeriodOfTime(startPeriod:Long,endPeriod:Long):LiveData<Long>
}
