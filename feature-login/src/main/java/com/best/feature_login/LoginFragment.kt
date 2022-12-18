package com.best.feature_login

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import com.best.utils.NavCommand
import com.best.utils.NavCommands
import com.best.utils.navigate

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.loginTextView).setOnClickListener {
            requireContext().getSharedPreferences(getString(R.string.login_fragment), 0)
                .edit {
                    putString("TOKEN_KEY", "Some Token")
                }

            navigate(
                navCommand = NavCommand(
                    target = NavCommands.DeepLink(
                        uri = Uri.parse("jetnavapp://main/Egor Zakharin/Ekat"),
                        isModal = true,
                        isSingleTop = true
                    )
                )
            )
        }
    }
}