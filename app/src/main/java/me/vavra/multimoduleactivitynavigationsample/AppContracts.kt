package me.vavra.multimoduleactivitynavigationsample

import me.vavra.multimoduleactivitynavigationsample.feature2.Feature2Activity
import me.vavra.multimoduleactivitynavigationsample.feature3.Feature3Activity
import me.vavra.multimoduleactivitynavigationsample.navigation.Contracts
import me.vavra.multimoduleactivitynavigationsample.navigation.contracts.Feature2Contract
import me.vavra.multimoduleactivitynavigationsample.navigation.contracts.Feature3Contract

class AppContracts: Contracts {
    override val feature2Contract = Feature2Contract(Feature2Activity::class.java)
    override val feature3Contract = Feature3Contract(Feature3Activity::class.java)
}