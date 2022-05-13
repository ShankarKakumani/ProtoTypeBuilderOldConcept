/**
 * Author : Mani Shankar Kakumani,
 * Created on : 13 May, 2022.
 */

package com.prototypebuilder.domain.usecase

import com.prototypebuilder.domain.core.enum.DataType
import com.prototypebuilder.domain.core.usecase.AdvancedUseCase
import com.prototypebuilder.domain.repository.AppRepository
import javax.inject.Inject

class DeleteAppByIdUseCase @Inject constructor(
    private val appRepository: AppRepository
) : AdvancedUseCase<Boolean, DeleteAppByIdUseCase.Params>() {

    data class Params(
        val appId: Int
    )

    override suspend fun run(dataType: DataType, params: Params): Boolean {
        return appRepository.deleteApp(appId = params.appId)
    }

}