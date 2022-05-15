/**
 * Author : Mani Shankar Kakumani,
 * Created on : 14 May, 2022.
 */

package com.prototypebuilder.app.views.appInfo

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prototypebuilder.domain.core.base.AppModel
import com.prototypebuilder.domain.core.resource.Resource
import com.prototypebuilder.domain.core.usecase.UseCaseResponse
import com.prototypebuilder.domain.usecase.GetAppByIdUseCase
import com.simpleenergy.domain.core.error.ApiError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class AppInfoViewModel @Inject constructor(
    private val getAppByIdUseCase: GetAppByIdUseCase
) : ViewModel() {

    var navigator: AppInfoNavigator? = null
    val appByIdState: MutableState<AppModel?> = mutableStateOf(null)

    fun getAppById(appId: Long): MutableState<Resource<Flow<AppModel?>>> {
        return getAppByIdUseCase.invokeState(
            scope = viewModelScope,
            params = GetAppByIdUseCase.Params(appId),
            callback = getAppByIdCallback()
        )
    }

    private fun getAppByIdCallback(): UseCaseResponse<Flow<AppModel?>> {
        return object : UseCaseResponse<Flow<AppModel?>> {
            override suspend fun onSuccess(result: Flow<AppModel?>) {
                result.collect {
                    it?.let {
                        appByIdState.value = it
                    }
                }
            }

            override suspend fun onError(apiError: ApiError?) {

            }

        }
    }

    fun setUpNavigator(navigator: AppInfoNavigator) {
        this.navigator = navigator
    }
}