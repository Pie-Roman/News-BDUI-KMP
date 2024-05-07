package ru.pyroman.news.base.uikit.presenter

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.pyroman.mvpkmp.MvpPresenter
import ru.pyroman.mvpkmp.MvpView
import kotlin.coroutines.CoroutineContext

open class BaseMvpPresenter<View : MvpView> : MvpPresenter<View>() {

    private val coroutineScopeDelegate = lazy {
        CoroutineScope(
            context = Dispatchers.Main.immediate
                    + SupervisorJob()
        )
    }

    private val coroutineScope by coroutineScopeDelegate

    protected fun <T> launch(
        context: CoroutineContext = Dispatchers.IO,
        block: suspend CoroutineScope.() -> T,
        onSuccess: (T) -> Unit,
        onError: (CoroutineContext, Throwable) -> Unit,
    ): Job {
        return coroutineScope.launch(
            context = context + CoroutineExceptionHandler(onError),
            block = {
                val result = block()
                withContext(Dispatchers.Main) {
                    onSuccess.invoke(result)
                }
            },
        )
    }
}