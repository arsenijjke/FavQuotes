package com.arsenijjke.domain.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [DomainModule::class],
    dependencies = [DomainDependencies::class]
)
interface DomainComponent : DomainProvisions {

    @Component.Builder
    interface Builder {
        fun dependencies(instance: DomainDependencies): Builder
        fun build(): DomainComponent
    }
}