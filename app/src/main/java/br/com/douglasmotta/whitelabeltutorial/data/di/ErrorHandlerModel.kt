package br.com.douglasmotta.whitelabeltutorial.data.di

import br.com.douglasmotta.whitelabeltutorial.data.GeneralErrorHandlerImpl
import br.com.douglasmotta.whitelabeltutorial.domain.ErrorHandler
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ErrorHandlerModel {

    @Singleton
    @Binds
    fun bindErrorHandler(errorHandler: GeneralErrorHandlerImpl): ErrorHandler
}