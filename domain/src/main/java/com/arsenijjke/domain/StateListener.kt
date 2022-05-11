package com.arsenijjke.domain

interface StateListener {

    fun onLoading()

    fun onSuccess(message:String?)

    fun onError(message: String)
}