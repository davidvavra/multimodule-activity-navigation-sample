package me.vavra.multimoduleactivitynavigationsample.navigation.contracts

import android.app.Activity
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import me.vavra.multimoduleactivitynavigationsample.navigation.BaseContract

class Feature2Contract(activityClass: Class<out Activity>): BaseContract<Feature2Contract.Args, Feature2Contract.Result>(activityClass) {

    @Parcelize
    data class Args(
        val argument1: String
    ): Parcelable

    @Parcelize
    data class Result(
        val result1: String
    ): Parcelable
}