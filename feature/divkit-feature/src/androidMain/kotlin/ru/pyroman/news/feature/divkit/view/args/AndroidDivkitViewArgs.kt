package ru.pyroman.news.feature.divkit.view.args

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.pyroman.news.feature.divkit.view.DivkitViewArgs

@Parcelize
class AndroidDivkitViewArgs(
    override val query: String,
) : DivkitViewArgs, Parcelable