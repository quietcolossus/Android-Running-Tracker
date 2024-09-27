package com.quietcolossus.core.data.run

import com.quietcolossus.core.domain.run.LocalRunDataSource
import com.quietcolossus.core.domain.run.RemoteRunDataSource
import com.quietcolossus.core.domain.run.Run
import com.quietcolossus.core.domain.run.RunId
import com.quietcolossus.core.domain.run.RunRepository
import com.quietcolossus.core.domain.util.DataError
import com.quietcolossus.core.domain.util.Result
import com.quietcolossus.core.domain.util.EmptyResult
import com.quietcolossus.core.domain.util.asEmptyDataResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class OfflineFirstRunRepository(
    private val localRunDataSource: LocalRunDataSource,
    private val remoteRunDataSource: RemoteRunDataSource,
    private val applicationScope: CoroutineScope
): RunRepository {
    override fun getRuns(): Flow<List<Run>> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchRuns(): EmptyResult<DataError> {
        return when(val result = remoteRunDataSource.getRuns()) {
            is Result.Error -> result.asEmptyDataResult()
            is Result.Success -> {
                applicationScope.async {
                    localRunDataSource.upsertRuns(result.data).asEmptyDataResult()
                }.await()
            }
        }
    }

    override suspend fun upsertRun(run: Run, mapPicture: ByteArray): EmptyResult<DataError> {
        val localResult = localRunDataSource.upsertRun(run)
        if (localResult !is Result.Success) {
            return localResult.asEmptyDataResult()
        }

        val runWithId = run.copy(id = localResult.data)
        val remoteResult = remoteRunDataSource.postRun(
            run = runWithId,
            mapPicture = mapPicture
        )

        return when(remoteResult) {
            is Result.Error -> {
                Result.Success(Unit)
            }
            is Result.Success -> {
                applicationScope.async {
                    localRunDataSource.upsertRun(remoteResult.data).asEmptyDataResult()
                }.await()
            }
        }
    }

    override suspend fun deleteRun(id: RunId) {
        localRunDataSource.deleteRun(id)

        val remoteResult = applicationScope.async {
            remoteRunDataSource.deleteRun(id)
        }.await()
    }
}