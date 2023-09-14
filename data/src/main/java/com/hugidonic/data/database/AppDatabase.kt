package com.hugidonic.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hugidonic.data.database.entities.ScheduleDayEntity
import com.hugidonic.data.database.entities.SubjectEntity

@Database(
    entities = [
        ScheduleDayEntity::class,
        SubjectEntity::class,
    ],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun scheduleDao(): ScheduleDao
    abstract fun subjectDao(): SubjectDao

    companion object {
        private var db: AppDatabase? = null
        private const val DB_NAME = "schedule.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance = Room.databaseBuilder(
                    context = context,
                    klass = AppDatabase::class.java,
                    name = DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                db = instance
                return instance
            }
        }

    }
}