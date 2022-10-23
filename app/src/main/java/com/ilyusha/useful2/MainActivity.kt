package com.ilyusha.useful2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ilyusha.useful2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        val btNav: BottomNavigationView = binding.navMainView
        val navControllerFragment = supportFragmentManager.findFragmentById(R.id.nav_controller_fragment) as NavHostFragment
        navController = navControllerFragment.navController

        val appBarConf = AppBarConfiguration(setOf(
            R.id.nav_weather, R.id.nav_crypto
        ))

        setupActionBarWithNavController(navController, appBarConf)
        btNav.setupWithNavController(navController)
    }
}