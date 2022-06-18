package com.logistreams.mvvmmaps.domain.repository

import com.logistreams.mvvmmaps.data.ParkingSpotDao
import com.logistreams.mvvmmaps.domain.model.ParkingSpot
import kotlinx.coroutines.flow.Flow

interface ParkingSpotRepository {
    suspend fun insertParkingSpot(spot: ParkingSpot)

    suspend fun deleteParkingSpot(spot: ParkingSpot)

     fun getParkingSpots() : Flow<List<ParkingSpot>>
}