package ru.agladkov.feature_main

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.best.feature_main.R

class FeedFragment: Fragment(R.layout.fragment_feed) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.feedItemView).setOnClickListener {
            val navOptions = NavOptions.Builder()
                .setEnterAnim(com.best.utils.R.anim.slide_in_left)
                .setExitAnim(com.best.utils.R.anim.slide_out_left)
                .setPopEnterAnim(com.best.utils.R.anim.slide_in_left)
                .setPopExitAnim(com.best.utils.R.anim.slide_out_right)
                .build()

            findNavController().navigate(Uri.parse("jetnavapp://detail"), navOptions)
        }
    }
}