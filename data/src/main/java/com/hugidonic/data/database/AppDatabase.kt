package com.hugidonic.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hugidonic.data.database.models.ScheduleDayDbModel

@Database(entities = [ScheduleDayDbModel::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

	abstract fun scheduleDao(): ScheduleDao

	companion object {
		private var db: AppDatabase? = null
		private const val DB_NAME = "schedule.db"
		private val LOCK = Any()

		fun getInstance(context: Context): AppDatabase {
			synchronized(LOCK) {
				db?.let  { return it }
				val instance = Room.databaseBuilder(
					context=context,
					klass=AppDatabase::class.java,
					name= DB_NAME
				)
					.fallbackToDestructiveMigration()
					.build()
				db = instance
				return instance
			}
		}

	}
}