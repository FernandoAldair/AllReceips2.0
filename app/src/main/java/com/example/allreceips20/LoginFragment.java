package com.example.allreceips20;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.allreceips20.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private AutenticacionViewModel autenticacionViewModel;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentLoginBinding.inflate(inflater, container, false)).getRoot();
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
////        autenticacionViewModel = new ViewModelProvider(requireActivity()).get(AutenticacionViewModel.class);
////        navController = Navigation.findNavController(view);
////
//////        BOTON REGISTRO
////        binding.buttonRegister.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                navController.navigate(R.id.action_loginFragment_to_registroFragment);
////            }
////        });
////
//////        BOTON INICIAR SESION
////        binding.buttonIniciar.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                String username = binding.Email.getText().toString();
////                String password = binding.Password.getText().toString();
////
////                autenticacionViewModel.iniciarSesion(username, password);
////            }
////        });
////
//////        BOTON INVITADO
////        binding.buttonInvitado.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                navController.navigate(R.id.action_loginFragment_to_bottomMenuFragment);
////            }
////        });
////
////
////
////        autenticacionViewModel.estadoDeLaAutenticacion.observe(getViewLifecycleOwner(), new Observer<AutenticacionViewModel.EstadoDeLaAutenticacion>() {
////            @Override
////            public void onChanged(AutenticacionViewModel.EstadoDeLaAutenticacion estadoDeLaAutenticacion) {
////                switch (estadoDeLaAutenticacion){
////                    case AUTENTICADO:
//////                        navController.navigate(R.id.action_iniciarSesionFragment_to_inicioFragment);
////                        break;
////
////                    case AUTENTICACION_INVALIDA:
////                        Toast.makeText(getContext(), "CREDENCIALES NO VALIDAS", Toast.LENGTH_SHORT).show();
////                        break;
////                }
////            }
////        });
//
//
//
//    }
}