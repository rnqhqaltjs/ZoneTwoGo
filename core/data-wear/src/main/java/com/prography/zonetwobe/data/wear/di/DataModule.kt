package com.prography.zonetwobe.data.wear.di

import com.prography.zonetwobe.data.wear.repository.HealthServicesRepositoryImpl
import com.prography.zonetwobe.domain.repository.HealthServicesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindHeartRateRepository(heartRateRepositoryImpl: HealthServicesRepositoryImpl): HealthServicesRepository

}

