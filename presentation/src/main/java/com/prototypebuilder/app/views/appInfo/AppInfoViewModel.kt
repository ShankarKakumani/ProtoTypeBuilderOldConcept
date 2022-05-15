/**
 * Author : Mani Shankar Kakumani,
 * Created on : 14 May, 2022.
 */

package com.prototypebuilder.app.views.appInfo

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prototypebuilder.domain.core.base.ActivityModel
import com.prototypebuilder.domain.core.base.AppModel
import com.prototypebuilder.domain.core.resource.Resource
import com.prototypebuilder.domain.core.usecase.UseCaseResponse
import com.prototypebuilder.domain.usecase.activity.GetActivityByAppIdUseCase
import com.prototypebuilder.domain.usecase.activity.InsertActivityUseCase
import com.prototypebuilder.domain.usecase.app.GetAppByIdUseCase
import com.simpleenergy.domain.core.error.ApiError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class AppInfoViewModel @Inject constructor(
    private val getAppByIdUseCase: GetAppByIdUseCase,
    private val getActivityByAppIdUseCase: GetActivityByAppIdUseCase,
    private val insertActivityUseCase: InsertActivityUseCase
) : ViewModel() {

    var navigator: AppInfoNavigator? = null
    val appByIdState: MutableState<AppModel?> = mutableStateOf(null)
    val activityListState: MutableState<List<ActivityModel>> by lazy {
        mutableStateOf(emptyList())
    }

    fun getAppById(appId: Long): MutableState<Resource<Flow<AppModel?>>> {
        return getAppByIdUseCase.invokeState(
            scope = viewModelScope,
            params = GetAppByIdUseCase.Params(appId),
            callback = getAppByIdCallback()
        )
    }

    fun getActivityListByAppId(appId: Long) {
        getActivityByAppIdUseCase.invoke(
            viewModelScope,
            callback = getActivityListCallBack(),
            params = GetActivityByAppIdUseCase.Params(appId)
        )
    }

    fun insertActivity(activityModel: ActivityModel) {
        insertActivityUseCase.invoke(viewModelScope, getInsertActivityCallback(), InsertActivityUseCase.Params(activityModel))
    }

    private fun getInsertActivityCallback(): UseCaseResponse<Boolean> {
        return object : UseCaseResponse<Boolean> {
            override suspend fun onSuccess(result: Boolean) {

            }

            override suspend fun onError(apiError: ApiError?) {

            }

        }
    }

    private fun getActivityListCallBack(): UseCaseResponse<Flow<List<ActivityModel>>> {
        return object : UseCaseResponse<Flow<List<ActivityModel>>> {
            override suspend fun onSuccess(result: Flow<List<ActivityModel>>) {
                result.collect {
                    activityListState.value = it
                }
            }

            override suspend fun onError(apiError: ApiError?) {

            }

        }
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