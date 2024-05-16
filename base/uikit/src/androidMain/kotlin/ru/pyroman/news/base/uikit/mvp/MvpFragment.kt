package ru.pyroman.news.base.uikit.mvp

import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class MvpFragment : Fragment() {

    protected abstract val mvpDelegate: MvpDelegate<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mvpDelegate.onCreate()
    }

    override fun onStart() {
        super.onStart()
        mvpDelegate.onAttach()
    }

    override fun onStop() {
        super.onStop()
        mvpDelegate.onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()
        mvpDelegate.onDestroy()
    }
}