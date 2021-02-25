package com.example.allreceips20;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.allreceips20.databinding.FragmentDeleteConfBinding;

public class DeleteConfFragment extends DialogFragment {

    private FragmentDeleteConfBinding binding;
    private NavController navController;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentDeleteConfBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        RecetaViewModel recetaViewModel = new ViewModelProvider(requireActivity()).get(RecetaViewModel.class);

        binding.aceptareliminacion.setOnClickListener(v -> {

            recetaViewModel.confirmadaEliminacion = true;


        });

        binding.denegareliminacion.setOnClickListener(v -> {
            navController.popBackStack();
        });

    }
}