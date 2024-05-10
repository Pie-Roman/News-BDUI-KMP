package ru.pyroman.news.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import ru.pyroman.news.feature.divkit.view.args.AndroidDivkitViewArgs
import ru.pyroman.news.feature.divkit.view.fragment.DivkitFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val args = AndroidDivkitViewArgs(
            query = "news-list"
        )

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<DivkitFragment>(
                containerViewId = R.id.fragment_container,
                args = DivkitFragment.withArgs(args)
            )
        }
    }
}