package com.arsenijjke.domain.interfaces

interface AdapterController {

    fun setupAdapter()

    suspend fun cleanAdapterElements()

    suspend fun fillAdapter()
}