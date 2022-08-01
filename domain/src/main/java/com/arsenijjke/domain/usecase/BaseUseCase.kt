package com.arsenijjke.domain.usecase

import kotlinx.coroutines.flow.Flow

interface BaseUseCase<out Result> {
    suspend operator fun invoke(): Flow<Result>
}