package com.example.allreceips20.OtherList;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.List;

public class ElementosViewModel extends AndroidViewModel {

    ListaRepositorio listaRepositorio;

    MutableLiveData<RecetaPublica> elementoSeleccionado = new MutableLiveData<>();

    MutableLiveData<String> terminoBusqueda = new MutableLiveData<>();

    LiveData<List<RecetaPublica>> resultadoBusqueda = Transformations.switchMap(terminoBusqueda, new Function<String, LiveData<List<RecetaPublica>>>() {
        @Override
        public LiveData<List<RecetaPublica>> apply(String input) {
            return listaRepositorio.buscar(input);
        }
    });

    public ElementosViewModel(@NonNull Application application) {
        super(application);

        listaRepositorio = new ListaRepositorio(application);
    }


    LiveData<List<RecetaPublica>> obtener(){
        return listaRepositorio.obtener();
    }

    LiveData<List<RecetaPublica>> masValorados(){
        return listaRepositorio.masValorados();
    }

    LiveData<List<RecetaPublica>> buscar(){
        return resultadoBusqueda;
    }

    void insertar(RecetaPublica elemento){
        listaRepositorio.insertar(elemento);
    }

    void eliminar(RecetaPublica elemento){
        listaRepositorio.eliminar(elemento);
    }

    void actualizar(RecetaPublica elemento, float valoracion){
        listaRepositorio.actualizar(elemento, valoracion);
    }


    void seleccionar(RecetaPublica elemento){
        elementoSeleccionado.setValue(elemento);
    }

    MutableLiveData<RecetaPublica> seleccionado(){
        return elementoSeleccionado;
    }


    void establecerTerminoBusqueda(String s){
        terminoBusqueda.setValue(s);
    }
}