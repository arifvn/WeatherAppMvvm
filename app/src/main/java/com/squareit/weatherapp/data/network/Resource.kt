package com.squareit.weatherapp.data.network

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        LOADING,
        ERROR,
        SUCCESS
    }

    companion object {
        fun <T> loading(data: T?): Resource<T> =
            Resource(Status.LOADING, data, null)

        fun <T> error(data: T?, message: String? = null): Resource<T> =
            Resource(Status.ERROR, data, message)

        fun <T> success(data: T?, message: String? = null): Resource<T> =
            Resource(Status.SUCCESS, data, message)
    }
}