/**
 * Author: Mani Shankar Kakumani
 */

package com.prototypebuilder.domain.core.usecase

import com.simpleenergy.domain.core.error.ApiError

interface UseCaseResponse<Type> {

    suspend fun onSuccess(result: Type)

    suspend fun onError(apiError: ApiError?)
}

