package com.example.streamingapp.navigation

sealed class NavRoute(val route: String) {

    object Home : NavRoute("home")
    object SignUp : NavRoute("signUp")
    object SignIn : NavRoute("signIn")

}