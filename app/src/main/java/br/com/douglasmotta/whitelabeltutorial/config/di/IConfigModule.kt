package br.com.douglasmotta.whitelabeltutorial.config.di

import br.com.douglasmotta.whitelabeltutorial.config.ConfigImpl
import br.com.douglasmotta.whitelabeltutorial.config.IConfig
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface IConfigModule {

    @Binds
    fun bindConfig(config: ConfigImpl): IConfig
}