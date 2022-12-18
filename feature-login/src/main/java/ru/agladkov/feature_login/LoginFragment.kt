package ru.agladkov.feature_login

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.best.feature_login.R
import com.best.utils.NavCommand
import com.best.utils.NavCommands
import com.best.utils.navigate
import java.util.*

class LoginFragment: Fragment(R.layout.fragment_login) {

    @SuppressLint("CommitPrefEdits")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.loginTextView).setOnClickListener {
            requireContext().getSharedPreferences(getString(R.string.login_fragment), 0)
                .edit().putString("TOKEN_KEY", "Some Token").apply()
            navigate(
                NavCommand(
                    NavCommands.DeepLink(
                        uri = Uri.parse("jetnavapp://main/Alex Gladkov/Moscow"),
                        isModal = true,
                        isSingleTop = true
                    )
                )
            )
        }
    }
}