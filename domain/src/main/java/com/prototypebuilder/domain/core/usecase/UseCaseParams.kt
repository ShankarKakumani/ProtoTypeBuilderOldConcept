/**
 * Author: Mani Shankar Kakumani
 */

package com.prototypebuilder.domain.core.usecase

import com.prototypebuilder.domain.core.enum.DataType
import com.prototypebuilder.domain.core.error.traceErrorException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class UseCaseParams<T, in Parameter> {

    abstract suspend fun run(params: Parameter, dataType: DataType): T

    fun invoke(
        scope: CoroutineScope,
        onResult: UseCaseResponse<T>?,
        params: Parameter,
        dataType: DataType = DataType.ForceCacheStrategy
    ) {

        scope.launch {
            try {
                val result = run(params, dataType)
                onResult?.onSuccess(result)
            } catch (e: Throwable) {
                e.printStackTrace()
                onResult?.onError(traceErrorException(e))
            }
        }
    }

}