package ru.pyroman.news.base.uikit.utils

import android.os.Parcelable
import androidx.fragment.app.Fragment
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

@Suppress("Deprecation")
fun <T : Parcelable> Fragment.parcelableArg(key: String): ReadOnlyProperty<Fragment, T> {
    return ArgumentProperty { arguments?.getParcelable(key) }
}

internal class ArgumentProperty<T>(
    private val getter: (Fragment) -> T?
) : ReadOnlyProperty<Fragment, T> {

    private var cachedValue: Any? = NOT_INITIALIZED

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        if (cachedValue === NOT_INITIALIZED) {
            cachedValue = getter(thisRef)
        }

        return cachedValue as T
    }

    companion object {
        private val NOT_INITIALIZED = Any()
    }
}