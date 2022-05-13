/**
 * Author: Mani Shankar Kakumani
 */

package com.prototypebuilder.domain.core.usecase

import com.prototypebuilder.domain.core.enum.DataType
import com.prototypebuilder.domain.core.error.traceErrorException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class UseCase<T> {

    abstract suspend fun run(dataType: DataType): T

    fun invoke(
        scope: CoroutineScope,
        callback: UseCaseResponse<T>?,
        dataType: DataType = DataType.ForceCacheStrategy
    ) {

        scope.launch {
            try {
                val result = run(dataType)
                callback?.onSuccess(result)
            } catch (e: Throwable) {
                e.printStackTrace()
                callback?.onError(traceErrorException(e))
            }
        }
    }

}