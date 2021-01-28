package com.example.allreceips20;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.allreceips20.databinding.FragmentRecetaViewBinding;
import com.example.allreceips20.model.Receta;

public class RecetaViewFragment extends Fragment {


    private FragmentRecetaViewBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRecetaViewBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecetaViewModel recetaViewModel = new ViewModelProvider(requireActivity()).get(RecetaViewModel.class);

        recetaViewModel.seleccionado().observe(getViewLifecycleOwner(), new Observer<Receta>() {
            @Override
            public void onChanged(Receta receta) {
                binding.titulo.setText(receta.titulo);
                binding.descripcion.setText(receta.descripcion);
                binding.portada.setImageURI(Uri.parse(receta.portada));

            }
        });

    }
}