package com.hugidonic.kstuscheduler.di

import com.hugidonic.data.database.ScheduleDao
import com.hugidonic.data.remote.ApiFactory
import com.hugidonic.data.remote.ApiService
import com.hugidonic.data.repository.ScheduleRepositoryImpl
import com.hugidonic.domain.repositories.ScheduleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return ApiFactory().scheduleApi
    }

    @Provides
    @Singleton
    fun provideScheduleRepository(
        scheduleDao: ScheduleDao,
        apiService: ApiService
    ): ScheduleRepository {
        return ScheduleRepositoryImpl(
            scheduleDao = scheduleDao,
            apiService = apiService
        )
    }
}