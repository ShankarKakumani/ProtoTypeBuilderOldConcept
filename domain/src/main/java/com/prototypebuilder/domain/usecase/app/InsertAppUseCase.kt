/**
 * Author : Mani Shankar Kakumani,
 * Created on : 13 May, 2022.
 */

package com.prototypebuilder.domain.usecase.app

import com.prototypebuilder.domain.core.base.AppModel
import com.prototypebuilder.domain.core.enum.DataType
import com.prototypebuilder.domain.core.usecase.AdvancedUseCase
import com.prototypebuilder.domain.repository.AppRepository
import javax.inject.Inject

class InsertAppUseCase @Inject constructor(
    private val appRepository: AppRepository
) : AdvancedUseCase<Boolean, InsertAppUseCase.Params>() {

    data class Params(
        val appModel: AppModel
    )

    override suspend fun run(dataType: DataType, params: Params): Boolean {
        return appRepository.insertApp(appModel = params.appModel)
    }
}