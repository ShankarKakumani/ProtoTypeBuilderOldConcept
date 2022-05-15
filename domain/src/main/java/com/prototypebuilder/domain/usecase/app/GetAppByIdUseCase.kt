/**
 * Author : Mani Shankar Kakumani,
 * Created on : 13 May, 2022.
 */

package com.prototypebuilder.domain.usecase.app

import com.prototypebuilder.domain.core.base.AppModel
import com.prototypebuilder.domain.core.enum.DataType
import com.prototypebuilder.domain.core.usecase.AdvancedUseCase
import com.prototypebuilder.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAppByIdUseCase @Inject constructor(
    private val appRepository: AppRepository
) : AdvancedUseCase<Flow<AppModel?>, GetAppByIdUseCase.Params>() {

    data class Params(
        val appId: Long
    )

    override suspend fun run(dataType: DataType, params: Params): Flow<AppModel?> {
        return appRepository.getAppById(appId = params.appId)
    }

}