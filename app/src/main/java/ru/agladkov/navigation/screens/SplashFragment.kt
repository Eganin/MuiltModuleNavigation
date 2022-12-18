package ru.agladkov.navigation.screens

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.best.navigation.R
import com.best.utils.NavCommand
import com.best.utils.NavCommands
import com.best.utils.navigate

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val token = requireContext().getSharedPreferences(getString(com.best.feature_login.R.string.login_fragment), 0)
            .getString("TOKEN_KEY", "")

        if (token.isNullOrBlank()) {
            navigate(
                NavCommand(
                    NavCommands.DeepLink(
                        uri = Uri.parse("jetnavapp://login"),
                        isModal = true,
                        isSingleTop = true
                    )
                )
            )
        } else {
            navigate(
                NavCommand(
                    NavCommands.DeepLink(
                        uri = Uri.parse("jetnavapp://main/AlexGladkov/Moscow"),
                        isModal = true,
                        isSingleTop = true
                    )
                )
            )
        }
    }
}