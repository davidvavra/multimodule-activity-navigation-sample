package me.vavra.multimoduleactivitynavigationsample.common

import android.app.Activity
import android.os.Parcelable
import androidx.activity.ComponentActivity
import me.vavra.multimoduleactivitynavigationsample.navigation.BaseContract
import me.vavra.multimoduleactivitynavigationsample.navigation.Contracts
import me.vavra.multimoduleactivitynavigationsample.navigation.NoResult
import javax.inject.Inject
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

abstract class BaseActivity: ComponentActivity() {

    @Inject
    lateinit var contracts: Contracts

    fun <Args: Parcelable> BaseContract<Args, NoResult>.launch(args: Args? = null) {
        startActivity(this.createIntent(this@BaseActivity, args))
    }

    fun <Result: Parcelable> setContractResult(contract: BaseContract<*, Result>, result: Result) {
        setResult(Activity.RESULT_OK, contract.createResultIntent(result))
    }
}

inline fun <reified Args: Parcelable> Activity.contractArgs(crossinline lazyContract: ()->BaseContract<Args, *>): ReadOnlyProperty<Activity, Args> {
    return object : ReadOnlyProperty<Any, Args> {
        private var value: Args? = null
        override fun getValue(thisRef: Any, property: KProperty<*>): Args {
            if (value == null) {
                value = lazyContract().parseStartIntent(intent)
            }
            return value ?: throw RuntimeException("Missing contract args")
        }
    }
}