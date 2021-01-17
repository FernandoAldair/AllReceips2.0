package com.example.allreceips20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.allreceips20.databinding.ActivityMainBinding;
import com.example.allreceips20.databinding.FragmentBottomMenuBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FragmentBottomMenuBinding fragmentBottomMenuBinding;

    AutenticacionViewModel autenticacionViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        NavController navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_splash)).getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {

            if (destination.getId() == R.id.splashFragment || destination.getId() == R.id.loginFragment ) {
                binding.bottomNavigation.setVisibility(View.GONE);
            } else {
                binding.bottomNavigation.setVisibility(View.VISIBLE);
            }


        });

    }




}