package com.prototypebuilder.domain.core.usecase

import com.prototypebuilder.domain.core.enum.DataType
import com.prototypebuilder.domain.core.error.traceErrorException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

abstract class RoomDBUseCase<T, Parameter> {

    abstract suspend fun run(dataType: DataType, params: Parameter): T

    fun invoke(
        scope: CoroutineScope,
        callback: UseCaseResponse<T>? = null,
        params: Parameter,
        dataType: DataType = DataType.ForceCacheStrategy
    ) {
        scope.launch {
            try {
                run(params = params, dataType = dataType).apply {
                    callback?.onSuccess(this)
                }
            } catch (e: Exception) {
                callback?.onError(traceErrorException(e))
            }
        }

    }

    suspend fun invokeThread(
        scope: CoroutineScope,
        callback: UseCaseResponse<T>? = null,
        params: Parameter,
        dataType: DataType = DataType.ForceCacheStrategy
    ): T {
        return suspendCoroutine { continuation ->
            scope.launch {
                try {
                    run(params = params, dataType = dataType).apply {
                        continuation.resume(this)
                        callback?.onSuccess(this)
                    }
                } catch (e: Exception) {
                    callback?.onError(traceErrorException(e))
                }
            }
        }
    }

}