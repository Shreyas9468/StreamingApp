package com.example.streamingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.streamingapp.navigation.NavRoute
import com.example.streamingapp.ui.feature.home.HomeScreen
import com.example.streamingapp.ui.feature.login.LoginScreen
import com.example.streamingapp.ui.feature.signup.SignUpScreen
import com.example.streamingapp.ui.theme.StreamingAppTheme
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StreamingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val controller = rememberNavController()
                    val startDestination = if (FirebaseAuth.getInstance().currentUser != null) NavRoute.Home.route else NavRoute.SignIn.route
                    NavHost(
                        navController = controller,
                        startDestination = startDestination,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(NavRoute.Home.route) {
                            HomeScreen(navController = controller)
                        }
                        composable(NavRoute.SignUp.route) {
                            SignUpScreen(navController = controller)
                        }
                        composable(NavRoute.SignIn.route) {
                            LoginScreen(navController = controller)
                        }
                    }
                }

            }
        }
    }
}

