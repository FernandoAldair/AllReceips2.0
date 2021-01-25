package com.example.allreceips20;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.allreceips20.ListaBaseDeDatos.Receta;
import com.example.allreceips20.ListaBaseDeDatos.RecetaViewModel;
import com.example.allreceips20.databinding.FragmentMiListaBinding;
import com.example.allreceips20.databinding.ViewholderRecetaBinding;

import java.util.List;

public class MiListaFragment extends Fragment {

    private FragmentMiListaBinding binding;
    private RecetaViewModel recetaViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentMiListaBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recetaViewModel = new ViewModelProvider(requireActivity()).get(RecetaViewModel.class);

        RecetaAdapter recetaAdapter = new RecetaAdapter();
        binding.listaReceta.setAdapter(recetaAdapter);

        recetaViewModel.obtenerReceta().observe(getViewLifecycleOwner(),  receta ->{
            recetaAdapter.setRecetaList(receta);
        });
    }

    class RecetaAdapter extends RecyclerView.Adapter<RecetaViewHolder>{

        List<Receta> recetaList;

        @NonNull
        @Override
        public RecetaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new RecetaViewHolder(ViewholderRecetaBinding.inflate(getLayoutInflater(),parent,false));

        }

        @Override
        public void onBindViewHolder(@NonNull RecetaViewHolder holder, int position) {
            Receta receta = recetaList.get(position);
            holder.binding.titulo.setText(receta.titulo);
            holder.binding.descripcion.setText(receta.descripcion);



            Glide.with(holder.itemView)
                    .load(receta.portada)
                    .into(holder.binding.portada);
        }

        @Override
        public int getItemCount() {
            return recetaList == null ? 0 : recetaList.size();
        }

        void setRecetaList(List<Receta> recetaList){
            this.recetaList = recetaList;
            notifyDataSetChanged();
        }
    }

    class RecetaViewHolder extends RecyclerView.ViewHolder{
        ViewholderRecetaBinding binding;

        public RecetaViewHolder(@NonNull ViewholderRecetaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}