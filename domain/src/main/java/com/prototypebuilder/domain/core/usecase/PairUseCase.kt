/**
 * Author: Mani Shankar Kakumani
 */

package com.prototypebuilder.domain.core.usecase

import com.prototypebuilder.domain.core.enum.DataType
import com.prototypebuilder.domain.core.error.traceErrorException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class PairUseCase<LocalData, CloudData> {

    abstract suspend fun run(dataType: DataType): Pair<LocalData, CloudData>

    fun invoke(
        scope: CoroutineScope,
        callback: UseCaseResponse<Pair<LocalData, CloudData>>?,
        dataType: DataType = DataType.ForceCacheStrategy
    ) {

        scope.launch {
            try {
                val result = run(dataType)
                callback?.onSuccess(result)
            } catch (e: Throwable) {
                callback?.onError(traceErrorException(e))
            }
        }
    }

}