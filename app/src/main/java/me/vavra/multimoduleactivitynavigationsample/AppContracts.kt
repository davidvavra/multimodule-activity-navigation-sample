package me.vavra.multimoduleactivitynavigationsample

import me.vavra.multimoduleactivitynavigationsample.feature2.Feature2Activity
import me.vavra.multimoduleactivitynavigationsample.navigation.Contracts
import me.vavra.multimoduleactivitynavigationsample.navigation.contracts.Feature2Contract

class AppContracts: Contracts {
    override val feature2Contract = Feature2Contract(Feature2Activity::class.java)
}