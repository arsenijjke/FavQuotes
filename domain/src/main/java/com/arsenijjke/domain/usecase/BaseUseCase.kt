package com.arsenijjke.domain.usecase

import kotlinx.coroutines.flow.Flow

interface BaseUseCase<Result> {
    suspend operator fun invoke(): Flow<Result>
}