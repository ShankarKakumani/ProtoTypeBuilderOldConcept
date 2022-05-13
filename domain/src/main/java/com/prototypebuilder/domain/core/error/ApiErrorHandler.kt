/**
 * Author: Mani Shankar Kakumani
 */
package com.prototypebuilder.domain.core.error


import com.simpleenergy.domain.core.error.ApiError
import com.simpleenergy.domain.core.error.NO_INTERNET_ERROR_MESSAGE
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import java.net.SocketTimeoutException

/**
 * Trace exceptions(api call or parse data or connection errors) &
 * depending on what exception returns [ApiErrorf]
 *
 * */
fun traceErrorException(throwable: Throwable?): ApiError {

    return when (throwable) {

        is HttpException -> {
            return traceHttpException(throwable)
        }

        is SocketTimeoutException -> {
            ApiError(throwable.message, ApiError.ErrorStatus.TIMEOUT)
        }

        is IOException -> {
            ApiError(NO_INTERNET_ERROR_MESSAGE, 0, ApiError.ErrorStatus.NO_CONNECTION)
        }

        is Exception -> {
            return traceException(throwable)
        }

        else -> {
            ApiError(throwable?.localizedMessage, 0, ApiError.ErrorStatus.UNKNOWN_ERROR)
        }
    }
}

fun traceException(throwable: Exception): ApiError {
    return when (throwable.cause) {
        else -> {
            ApiError(throwable.localizedMessage, 0, ApiError.ErrorStatus.UNKNOWN_ERROR)
        }
    }
}

fun traceHttpException(throwable: HttpException): ApiError {
    return when (throwable.code()) {
        400 -> ApiError(
            throwable.message(),
            throwable.code(),
            ApiError.ErrorStatus.BAD_REQUEST
        )
        401 -> ApiError(
            throwable.message(),
            throwable.code(),
            ApiError.ErrorStatus.UNAUTHORIZED
        )
        403 -> ApiError(
            throwable.message(),
            throwable.code(),
            ApiError.ErrorStatus.FORBIDDEN
        )
        404 -> ApiError(
            throwable.message(),
            throwable.code(),
            ApiError.ErrorStatus.NOT_FOUND
        )
        405 -> ApiError(
            throwable.message(),
            throwable.code(),
            ApiError.ErrorStatus.METHOD_NOT_ALLOWED
        )
        409 -> ApiError(
            throwable.message(),
            throwable.code(),
            ApiError.ErrorStatus.CONFLICT
        )
        500 -> ApiError(
            throwable.message(),
            throwable.code(),
            ApiError.ErrorStatus.INTERNAL_SERVER_ERROR
        )
        else -> ApiError(
            throwable.localizedMessage,
            0,
            ApiError.ErrorStatus.UNKNOWN_ERROR
        )
    }
}
