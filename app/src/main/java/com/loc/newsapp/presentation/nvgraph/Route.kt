package com.loc.newsapp.presentation.nvgraph

sealed class Route(
    val route: String
){
    object OnBoardingScreen: Route("onBoardingScreen")
    object HomeScreen: Route("homeScreen")
    object SearchScreen: Route("searchScreen")
    object BookMarkScreen: Route("bookMarkScreen")
    object DetailScreen: Route("detailScreen")
    object AppStartNavigation: Route("appStartNavigation")
    object NewsNavigation: Route("newsNavigation")
    object NewsNavigatorScreen: Route("newsNavigatorScreen")
}