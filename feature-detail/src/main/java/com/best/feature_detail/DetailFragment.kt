package com.best.feature_detail

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var count = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        count = arguments?.getInt(COUNT_KEY) ?: 0

        view.findViewById<TextView>(R.id.detailTextView).apply {
            text = count.toString()
            setOnClickListener {
                if (count > 1)
                    findNavController().navigate(R.id.action_detailFragment_to_reviewsFragment)
                else
                    findNavController().navigate(
                        R.id.action_detailFragment_self,
                        bundleOf(
                            COUNT_KEY to (count + 1)
                        )
                    )
            }
        }
    }

    companion object {
        const val COUNT_KEY = "countKey"
    }
}