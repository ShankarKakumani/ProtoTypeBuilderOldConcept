package com.prototypebuilder.domain.usecase.activity

import com.prototypebuilder.domain.core.base.ActivityModel
import com.prototypebuilder.domain.core.enum.DataType
import com.prototypebuilder.domain.core.usecase.RoomDBUseCase
import com.prototypebuilder.domain.repository.ActivityRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetActivityListUseCase @Inject constructor(
    private val activityRepository: ActivityRepository
) : RoomDBUseCase<Flow<List<ActivityModel>>, GetActivityListUseCase.Params>() {

    data class Params(val appId: Long)

    override suspend fun run(dataType: DataType, params: Params): Flow<List<ActivityModel>> {
        return activityRepository.getActivityListByAppId(appId = params.appId)
    }
}