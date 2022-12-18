package ru.agladkov.feature_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.best.feature_detail.R

class ReviewsFragment : Fragment(R.layout.fragment_reviews) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        const val COUNT_KEY = "countKey"
    }
}