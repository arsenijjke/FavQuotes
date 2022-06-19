package com.arsenijjke.domain.interfaces

interface StateListener {

    fun onLoading()

    fun onSuccess(message:String?)

    fun onError(message: String)
}