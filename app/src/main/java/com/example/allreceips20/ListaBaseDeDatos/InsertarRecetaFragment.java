package com.example.allreceips20.ListaBaseDeDatos;

import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.allreceips20.databinding.FragmentInsertarRecetaBinding;

public class InsertarRecetaFragment extends Fragment {
    private FragmentInsertarRecetaBinding binding;
    private Uri imagenSeleccionada;
    private RecetaViewModel recetaViewModel;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding=FragmentInsertarRecetaBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recetaViewModel = new ViewModelProvider(requireActivity()).get(RecetaViewModel.class);

        navController = Navigation.findNavController(view);

        binding.insertar.setOnClickListener(v -> {

            if (imagenSeleccionada != null) {
                String titulo = binding.titulo.getText().toString();
                String descripcion = binding.descripcion.getText().toString();

                recetaViewModel.insertarReceta(titulo, descripcion, imagenSeleccionada.toString());

                recetaViewModel.establecerImagenSeleccionada(null);
                navController.popBackStack();
            } else {
                Toast.makeText(requireContext(), "Selecciona una imagen", Toast.LENGTH_SHORT).show();
            }
        });

        binding.portada.setOnClickListener(v ->{
            lanzadorGaleria.launch("image/*");
        });

        recetaViewModel.imagenSeleccionada.observe(getViewLifecycleOwner(), uri -> {
            if (uri != null) {
                imagenSeleccionada = uri;
                Glide.with(requireView()).load(uri).into(binding.portada);
            }
        });
    }
    private final ActivityResultLauncher<String> lanzadorGaleria = registerForActivityResult(new ActivityResultContracts.GetContent(), uri -> {
        recetaViewModel.establecerImagenSeleccionada(uri);
    });

}