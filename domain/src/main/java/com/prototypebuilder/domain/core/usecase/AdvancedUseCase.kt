/**
 * Author: Mani Shankar Kakumani
 */

package com.prototypebuilder.domain.core.usecase

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prototypebuilder.domain.core.enum.DataType
import com.prototypebuilder.domain.core.error.traceErrorException
import com.prototypebuilder.domain.core.resource.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class AdvancedUseCase<T, Params> {

    abstract suspend fun run(dataType: DataType, params: Params): T

    fun invokeLiveData(
        scope: CoroutineScope,
        callback: UseCaseResponse<T>? = null,
        dataType: DataType = DataType.ForceCacheStrategy,
        params: Params
    ): LiveData<Resource<T>> {
        val resourceData: MutableLiveData<Resource<T>> = MutableLiveData()
        scope.launch {
            try {
                resourceData.postValue(Resource.loading())
                run(dataType, params).apply {
                    resourceData.postValue(Resource.success(this))
                    callback?.onSuccess(this)
                }
            } catch (e: Throwable) {
                resourceData.postValue(Resource.error(e.message))
                callback?.onError(traceErrorException(e))
            }
        }
        return resourceData
    }


    fun invokeState(
        scope: CoroutineScope,
        callback: UseCaseResponse<T>? = null,
        dataType: DataType = DataType.ForceCacheStrategy,
        params: Params
    ): MutableState<Resource<T>> {
        val resourceData: MutableState<Resource<T>> = mutableStateOf(Resource.initial())
        scope.launch {
            try {
                resourceData.value = (Resource.loading())
                run(dataType, params).apply {
                    resourceData.value = (Resource.success(this))
                    callback?.onSuccess(this)
                }
            } catch (e: Throwable) {
                resourceData.value = (Resource.error(e.message))
                callback?.onError(traceErrorException(e))
            }
        }
        return resourceData
    }


    fun invokeFlow(
        scope: CoroutineScope,
        callback: UseCaseResponse<T>? = null,
        dataType: DataType = DataType.ForceCacheStrategy,
        params: Params
    ): Flow<Resource<T>> {
        val resourceData: MutableStateFlow<Resource<T>> = MutableStateFlow(Resource.initial())
        scope.launch {
            try {
                resourceData.value = Resource.loading()
                run(dataType, params).apply {
                    resourceData.value = Resource.success(this)
                    callback?.onSuccess(this)
                }
            } catch (e: Throwable) {
                resourceData.value = (Resource.error(e.message))
                callback?.onError(traceErrorException(e))
            }
        }
        return resourceData
    }

}