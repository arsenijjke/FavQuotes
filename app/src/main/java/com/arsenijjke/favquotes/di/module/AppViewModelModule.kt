package com.arsenijjke.favquotes.di.module

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck
import dagger.multibindings.Multibinds

@DisableInstallInCheck
@Module
interface AppViewModelModule {

    @Multibinds
    fun multibindViewModels(): Map<Class<out ViewModel>, @JvmSuppressWildcards ViewModel>
}