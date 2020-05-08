package com.repository.skeleton.data.remote.exception

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException

/**
 *  Holder class for wrapping exceptions from Network layer
 */
class RetrofitException(message: String?,
                        private val url: String?,
                        private val response: Response<*>?,
                        private val kind: Kind,
                        exception: Throwable?,
                        private val retrofit: Retrofit?) : RuntimeException(message, exception) {

    private var error: Error? = null

    companion object {
        fun httpError(url: String, response: Response<*>, retrofit: Retrofit): RetrofitException {
            val message = response.code().toString() + " " + response.message()
            val error = RetrofitException(
                message,
                url,
                response,
                Kind.HTTP,
                null,
                retrofit
            )
            error.deserializeServerError()
            return error
        }

        fun networkError(exception: IOException): RetrofitException {
            return RetrofitException(
                exception.message,
                null,
                null,
                Kind.NETWORK,
                exception,
                null
            )
        }

        fun unexpectedError(exception: Throwable): RetrofitException {
            return RetrofitException(
                exception.message,
                null,
                null,
                Kind.UNEXPECTED,
                exception,
                null
            )
        }
    }

    /** The request KEY_URL which produced the error. */
    fun getUrl() = url

    /** Response object containing type code, headers, body, etc. */
    fun getResponse() = response

    /** The event kind which triggered this error. */
    fun getKind() = kind

    /** The event kind which triggered this error. */
    fun getErrorMessage() = error?.message

    /** The event code which triggered this error. */
    fun getErrorCode() = error?.message

    /** The Retrofit this request was executed on */
    fun getRetrofit() = retrofit

    private fun deserializeServerError() {
        if (response?.errorBody() != null) {
            try {
                //error = getErrorBodyAs(Payload::class.java)?.error
            } catch (e: IOException) {

            }
        }
    }

    /**
     * HTTP response body converted to specified `type`. `null` if there is no
     * response.

     * @throws IOException if unable to convert the body to the specified `type`.
     */
    @Throws(IOException::class)
    private fun <T> getErrorBodyAs(type: Class<T>): T? {
        val errorBody = response?.errorBody()
        if (errorBody == null || retrofit == null) {
            return null
        }
        return try {
            val converter: Converter<ResponseBody, T> =
                retrofit.responseBodyConverter(type, arrayOfNulls<Annotation>(0))
            converter.convert(errorBody)
        } catch (e: IllegalArgumentException) {
            null
        }
    }

    enum class Kind {
        /** An [IOException] occurred while communicating to the server.  */
        NETWORK,
        /** A non-200 HTTP type code was received from the server.  */
        HTTP,
        /**
         * An internal error occurred while attempting to execute a request. It is best practice to
         * re-throw this exception so your application crashes.
         */
        UNEXPECTED,
        /**
         * An internal error thrown when the app is in maintenance mode
         */
        MAINTENANCE;
    }
}