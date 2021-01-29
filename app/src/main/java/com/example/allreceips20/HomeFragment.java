package com.example.allreceips20;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.allreceips20.databinding.FragmentHomeBinding;
import com.example.allreceips20.databinding.ViewholderRecetaBinding;
import com.example.allreceips20.model.Receta;

import java.util.List;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecetaViewModel recetaViewModel;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentHomeBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        recetaViewModel = new ViewModelProvider(requireActivity()).get(RecetaViewModel.class);

        RecetaAdapter2 recetaAdapter = new RecetaAdapter2();
        binding.listaReceta2.setAdapter(recetaAdapter);

        recetaViewModel.obtenerRecetasIniciales().observe(getViewLifecycleOwner(),  receta ->{
            recetaAdapter.setRecetaList2(receta);
        });
//
        binding.filtrar.setOnClickListener(v -> navController.navigate(R.id.action_homeFragment_to_filtroFragment));
    }


    class RecetaAdapter2 extends RecyclerView.Adapter<RecetaViewHolder2>{
        List<Receta> recetaList;

        @NonNull
        @Override
        public RecetaViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new RecetaViewHolder2(ViewholderRecetaBinding.inflate(getLayoutInflater(),parent,false));
        }
        @Override
        public void onBindViewHolder(@NonNull RecetaViewHolder2 holder, int position) {
            Receta receta = recetaList.get(position);
            holder.binding.titulo.setText(receta.titulo);
//            holder.binding.descripcion.setText(receta.descripcion);

            Glide.with(holder.itemView).load(receta.portada).into(holder.binding.portada);

            holder.binding.buttonSocial.setOnClickListener(v ->{
                navController.navigate(R.id.action_homeFragment_to_socialButtonsFragment);
            });

            // CUANDO DAS CLICL EN LA RECETA
            holder.itemView.setOnClickListener(v -> {
                recetaViewModel.seleccionar(receta);
                navController.navigate(R.id.action_homeFragment_to_recetaViewFragment);
            });


        }

        @Override
        public int getItemCount() {
            return recetaList == null ? 0 : recetaList.size();
        }

        void setRecetaList2(List<Receta> recetaList){
            this.recetaList = recetaList;
            notifyDataSetChanged();
        }
    }

    class RecetaViewHolder2 extends RecyclerView.ViewHolder{
        ViewholderRecetaBinding binding;

        public RecetaViewHolder2(@NonNull ViewholderRecetaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}