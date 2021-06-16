package me.vavra.multimoduleactivitynavigationsample.navigation.contracts

import android.app.Activity
import me.vavra.multimoduleactivitynavigationsample.navigation.BaseContract
import me.vavra.multimoduleactivitynavigationsample.navigation.NoArgs
import me.vavra.multimoduleactivitynavigationsample.navigation.NoResult

class Feature3Contract(activityClass: Class<out Activity>): BaseContract<NoArgs, NoResult>(activityClass)