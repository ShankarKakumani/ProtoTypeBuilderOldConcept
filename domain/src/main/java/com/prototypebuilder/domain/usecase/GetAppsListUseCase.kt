/**
 * Author : Mani Shankar Kakumani,
 * Created on : 13 May, 2022.
 */

package com.prototypebuilder.domain.usecase

import com.prototypebuilder.domain.core.base.AppModel
import com.prototypebuilder.domain.core.enum.DataType
import com.prototypebuilder.domain.core.usecase.AdvancedUseCase
import com.prototypebuilder.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAppsListUseCase @Inject constructor(
    private val appRepository: AppRepository
) : AdvancedUseCase<Flow<List<AppModel>>, Unit>() {

    override suspend fun run(dataType: DataType, params: Unit): Flow<List<AppModel>> {
        return appRepository.getAppsList()
    }

}