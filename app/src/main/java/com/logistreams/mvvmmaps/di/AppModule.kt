package com.logistreams.mvvmmaps.di

import android.app.Application
import androidx.room.Room
import com.logistreams.mvvmmaps.data.ParkingSpotDatabase
import com.logistreams.mvvmmaps.data.ParkingSpotRepositoryImpl
import com.logistreams.mvvmmaps.domain.repository.ParkingSpotRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideParkingSpotDatabase(app: Application) : ParkingSpotDatabase {
        return  Room.databaseBuilder(
            app,
            ParkingSpotDatabase::class.java,
            "Parking_Spot.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideParkingSpotRepository(db: ParkingSpotDatabase) : ParkingSpotRepository{
        return ParkingSpotRepositoryImpl(db.dao)
    }
}