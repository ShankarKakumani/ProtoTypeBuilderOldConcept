/**
 * Author: Mani Shankar Kakumani
 */

package com.prototypebuilder.domain.core.usecase

import com.prototypebuilder.domain.core.enum.DataType
import com.prototypebuilder.domain.core.error.traceErrorException
import com.prototypebuilder.domain.core.resource.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

abstract class UseCaseParams<T, in Parameter> {

    abstract suspend fun run(params: Parameter, dataType: DataType): T

    fun invoke(
        scope: CoroutineScope,
        callback: UseCaseResponse<T>? = null,
        params: Parameter,
        dataType: DataType = DataType.ForceCacheStrategy
    ) {

        scope.launch {
            try {
                val result = run(params, dataType)
                callback?.onSuccess(result)
            } catch (e: Throwable) {
                e.printStackTrace()
                callback?.onError(traceErrorException(e))
            }
        }
    }

}