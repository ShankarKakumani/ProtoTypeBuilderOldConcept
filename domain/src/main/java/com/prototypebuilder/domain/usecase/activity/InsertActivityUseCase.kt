/**
 * Author : Mani Shankar Kakumani,
 * Created on : 13 May, 2022.
 */

package com.prototypebuilder.domain.usecase.activity

import com.prototypebuilder.domain.core.base.ActivityModel
import com.prototypebuilder.domain.core.base.AppModel
import com.prototypebuilder.domain.core.enum.DataType
import com.prototypebuilder.domain.core.usecase.AdvancedUseCase
import com.prototypebuilder.domain.core.usecase.UseCaseParams
import com.prototypebuilder.domain.core.usecase.UseCaseResponse
import com.prototypebuilder.domain.repository.ActivityRepository
import com.prototypebuilder.domain.repository.AppRepository
import javax.inject.Inject

class InsertActivityUseCase @Inject constructor(
    private val activityRepository: ActivityRepository
) : UseCaseParams<Boolean, InsertActivityUseCase.Params>() {

    data class Params(
        val activityModel: ActivityModel
    )

    override suspend fun run(params: Params, dataType: DataType): Boolean {
        return activityRepository.insertActivity(params.activityModel)
    }

}