package com.hugidonic.kstuscheduler.di

import android.content.Context
import com.hugidonic.data.database.AppDatabase
import com.hugidonic.data.database.entities.dao.NewsDao
import com.hugidonic.data.database.entities.dao.ScheduleDao
import com.hugidonic.data.database.entities.dao.SubjectDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return AppDatabase.getInstance(context = context)
    }

    @Provides
    @Singleton
    fun provideNewsDao(appDatabase: AppDatabase): NewsDao {
        return appDatabase.newsDao()
    }

    @Provides
    @Singleton
    fun provideScheduleDao(appDatabase: AppDatabase): ScheduleDao {
        return appDatabase.scheduleDao()
    }

    @Provides
    @Singleton
    fun provideSubjectDao(appDatabase: AppDatabase): SubjectDao {
        return appDatabase.subjectDao()
    }

}