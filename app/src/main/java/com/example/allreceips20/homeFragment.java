package com.example.allreceips20;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;


import com.bumptech.glide.Glide;
import com.example.allreceips20.ListaBaseDeDatos.Receta;
import com.example.allreceips20.ListaBaseDeDatos.RecetaViewModel;
import com.example.allreceips20.OtherList.ElementosViewModel;
import com.example.allreceips20.OtherList.RecetaPublica;
import com.example.allreceips20.databinding.FragmentHomeBinding;
import com.example.allreceips20.databinding.ViewholderRecetaBinding;

import java.util.List;


public class homeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecetaViewModel recetaViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentHomeBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recetaViewModel = new ViewModelProvider(requireActivity()).get(RecetaViewModel.class);

        RecetaAdapter2 recetaAdapter = new RecetaAdapter2();
        binding.listaReceta2.setAdapter(recetaAdapter);

        recetaViewModel.obtenerReceta().observe(getViewLifecycleOwner(),  receta ->{
            recetaAdapter.setRecetaList2(receta);
        });
    }

    class RecetaAdapter2 extends RecyclerView.Adapter<RecetaViewHolder2>{
        List<Receta> recetaList2;

        @NonNull
        @Override
        public RecetaViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new RecetaViewHolder2(ViewholderRecetaBinding.inflate(getLayoutInflater(),parent,false));
        }
        @Override
        public void onBindViewHolder(@NonNull RecetaViewHolder2 holder, int position) {
            Receta receta = recetaList2.get(position);
            holder.binding.titulo.setText(receta.titulo);
//            holder.binding.descripcion.setText(receta.descripcion);

            Glide.with(holder.itemView).load(receta.portada).into(holder.binding.portada);
        }

        @Override
        public int getItemCount() {
            return recetaList2 == null ? 0 : recetaList2.size();
        }

        void setRecetaList2(List<Receta> recetaList){
            this.recetaList2 = recetaList;
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


    //    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        ElementosViewModel elementosViewModel = new ViewModelProvider(requireActivity()).get(ElementosViewModel.class);
//
//        elementosViewModel.seleccionado().observe(getViewLifecycleOwner(), new Observer<RecetaPublica>() {
//            @Override
//            public void onChanged(RecetaPublica elemento) {
//                binding.nombre.setText(elemento.nombre);
//                binding.descripcion.setText(elemento.descripcion);
//                binding.valoracion.setRating(elemento.valoracion);
//
//                binding.valoracion.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//                    @Override
//                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//                        if(fromUser){
//                            elementosViewModel.actualizar(elemento, rating);
//                        }
//                    }
//                });
//            }
//        });
//    }
//}