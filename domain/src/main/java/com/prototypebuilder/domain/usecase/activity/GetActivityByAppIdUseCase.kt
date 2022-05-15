package com.prototypebuilder.domain.usecase.activity

import com.prototypebuilder.domain.core.base.ActivityModel
import com.prototypebuilder.domain.core.enum.DataType
import com.prototypebuilder.domain.core.usecase.UseCaseParams
import com.prototypebuilder.domain.repository.ActivityRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetActivityByAppIdUseCase @Inject constructor(
    private val activityRepository: ActivityRepository
) : UseCaseParams<Flow<List<ActivityModel>>, GetActivityByAppIdUseCase.Params>() {


    data class Params(val appId: Long)

    override suspend fun run(params: Params, dataType: DataType): Flow<List<ActivityModel>> {
        return activityRepository.getActivityListByAppId(appId = params.appId)
    }
}