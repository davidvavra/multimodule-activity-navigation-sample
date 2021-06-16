package me.vavra.multimoduleactivitynavigationsample

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.vavra.multimoduleactivitynavigationsample.navigation.Contracts
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContracts(): Contracts {
        return AppContracts()
    }
}