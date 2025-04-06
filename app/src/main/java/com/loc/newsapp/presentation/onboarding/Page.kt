package com.loc.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R
//Data Foto atau Pages gitu
data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pageList = listOf(
    Page(
        title = "Latest News",
        description = "Stay informed with breaking news and updates from around the world",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Personalized Feed",
        description = "Get news recommendations based on your interests and preferences",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Save & Share",
        description = "Bookmark your favorite articles and share them with friends and family",
        image = R.drawable.onboarding3
    )
)
