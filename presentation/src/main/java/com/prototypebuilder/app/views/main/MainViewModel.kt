/**
 * Author : Mani Shankar Kakumani,
 * Created on : 13 May, 2022.
 */

package com.prototypebuilder.app.views.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prototypebuilder.domain.core.base.AppModel
import com.prototypebuilder.domain.core.resource.Resource
import com.prototypebuilder.domain.core.usecase.UseCaseResponse
import com.prototypebuilder.domain.usecase.DeleteAppByIdUseCase
import com.prototypebuilder.domain.usecase.GetAppByIdUseCase
import com.prototypebuilder.domain.usecase.GetAppsListUseCase
import com.prototypebuilder.domain.usecase.InsertAppUseCase
import com.simpleenergy.domain.core.error.ApiError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAppsListUseCase: GetAppsListUseCase,
    private val getAppByIdUseCase: GetAppByIdUseCase,
    private val insertAppUseCase: InsertAppUseCase,
    private val deleteAppByIdUseCase: DeleteAppByIdUseCase
) : ViewModel() {

    var navigator: MainNavigator? = null

    private var appByIdState: State<Resource<Flow<AppModel?>>> = mutableStateOf(Resource.initial())
    private var insertAppState: State<Resource<Boolean>> = mutableStateOf(Resource.initial())
    private var deleteAppState: State<Resource<Boolean>> = mutableStateOf(Resource.initial())

    var appsListState: MutableState<List<AppModel>> = mutableStateOf(emptyList())

    init {
        getAppsList()
    }

    fun getAppById(appId: Long) {
        appByIdState = getAppByIdUseCase.invokeState(
            scope = viewModelScope,
            params = GetAppByIdUseCase.Params(appId)
        )
    }

    fun insertApp(appModel: AppModel) {
        insertAppState = insertAppUseCase.invokeState(
            scope = viewModelScope,
            params = InsertAppUseCase.Params(appModel),
            callback = getInsertAppCallBack()
        )
    }

    fun deleteApp(appId: Long) {
        deleteAppState = deleteAppByIdUseCase.invokeState(
            scope = viewModelScope,
            params = DeleteAppByIdUseCase.Params(appId)
        )
    }

    private fun getInsertAppCallBack(): UseCaseResponse<Boolean> {
        return object : UseCaseResponse<Boolean> {
            override suspend fun onSuccess(result: Boolean) {
//                getAppsList()
            }

            override suspend fun onError(apiError: ApiError?) {
                apiError?.message
            }
        }
    }

    fun getAppsList() {
        getAppsListUseCase.invokeState(
            scope = viewModelScope,
            params = Unit,
            callback = getAppsListCallback()
        )
    }

    private fun getAppsListCallback(): UseCaseResponse<Flow<List<AppModel>>> {
        return object : UseCaseResponse<Flow<List<AppModel>>> {
            override suspend fun onSuccess(result: Flow<List<AppModel>>) {
                result.collect {
                    appsListState.value = it
                }
            }

            override suspend fun onError(apiError: ApiError?) {

            }
        }
    }

    fun setUpNavigator(navigator: MainNavigator) {
        this.navigator = navigator
    }
}