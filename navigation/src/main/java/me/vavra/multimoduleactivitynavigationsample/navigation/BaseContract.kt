package me.vavra.multimoduleactivitynavigationsample.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import androidx.activity.result.contract.ActivityResultContract
import kotlinx.parcelize.Parcelize

abstract class BaseContract<Args: Parcelable, Result: Parcelable>(private val activityClass: Class<out Activity>): ActivityResultContract<Args, Result>(){

    companion object {
        private const val INTENT_ARGS = "contract.intent.args"
        private const val INTENT_RESULT = "contract.intent.result"
    }

    override fun createIntent(context: Context, args: Args?): Intent {
        return Intent(context, activityClass).apply {
            putExtra(INTENT_ARGS, args)
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Result? {
        if (resultCode != Activity.RESULT_OK) {
            return null
        }
        return intent?.let { intent.getParcelableExtra(INTENT_RESULT) as Result? }
    }

    fun parseStartIntent(intent: Intent): Args {
        return requireNotNull(intent.getParcelableExtra(INTENT_ARGS)) as Args
    }

    fun parseOptionalStartIntent(intent: Intent): Args? {
        return intent.getParcelableExtra(INTENT_ARGS) as Args?
    }

    fun createResultIntent(result: Result): Intent {
        return Intent().apply {
            putExtra(INTENT_RESULT, result)
        }
    }
}

@Parcelize
class NoArgs : Parcelable

@Parcelize
class NoResult : Parcelable