package ru.agladkov.navigation

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.best.navigation.R
import com.best.utils.NavCommand
import com.best.utils.NavCommands
import com.best.utils.NavigationProvider

class MainActivity : AppCompatActivity(), NavigationProvider {

    private val navController: NavController
        get() = findNavController(R.id.containerView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun launch(navCommand: NavCommand) {
        when (val target = navCommand.target) {
            is NavCommands.DeepLink -> openDeepLink(
                url = target.uri,
                isModal = target.isModal,
                isSingleTop = target.isSingleTop
            )
            is NavCommands.Browser -> openBrowser(url = target.url)
        }
    }

    private fun openDeepLink(url: Uri, isModal: Boolean, isSingleTop: Boolean) {
        val navOptions = if (isModal) {
            NavOptions.Builder()
                .setEnterAnim(com.best.utils.R.anim.slide_in_up_enter)
                .setExitAnim(com.best.utils.R.anim.slide_out_up_enter)
                .setPopEnterAnim(com.best.utils.R.anim.slide_in_up_exit)
                .setPopExitAnim(com.best.utils.R.anim.slide_out_up_exit)
                .setLaunchSingleTop(isSingleTop)
                .setPopUpTo(if (isSingleTop) R.id.nav_graph_application else -1, inclusive = isSingleTop)
                .build()
        } else {
            NavOptions.Builder()
                .setEnterAnim(com.best.utils.R.anim.slide_in_left)
                .setExitAnim(com.best.utils.R.anim.slide_out_left)
                .setPopEnterAnim(com.best.utils.R.anim.slide_in_left)
                .setPopExitAnim(com.best.utils.R.anim.slide_out_right)
                .setLaunchSingleTop(isSingleTop)
                .setPopUpTo(if (isSingleTop) R.id.nav_graph_application else -1, inclusive = isSingleTop)
                .build()
        }

        navController.navigate(url, navOptions)
    }

    private fun openBrowser(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        browserIntent.setPackage("com.android.chrome")
        try {
            this.startActivity(browserIntent)
        } catch (ex: ActivityNotFoundException) {
            browserIntent.setPackage(null)
            this.startActivity(browserIntent)
        }
    }
}