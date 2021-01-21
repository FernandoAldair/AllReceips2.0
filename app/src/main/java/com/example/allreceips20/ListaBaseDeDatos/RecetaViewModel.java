package com.example.allreceips20.ListaBaseDeDatos;

import android.app.Application;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class RecetaViewModel  extends AndroidViewModel {

    MutableLiveData<Uri> imagenSeleccionada = new MutableLiveData<>();

    RecetaRepositorio recetaRepositorio;

    public RecetaViewModel(@NonNull Application application) {
        super(application);

        recetaRepositorio = new RecetaRepositorio(application);
    }

    public LiveData<List<Receta>> obtenerReceta() {
        return recetaRepositorio.obtenerReceta();
    }
    void insertarReceta(String titulo, String descripcion, String portada) {
        recetaRepositorio.insertarReceta(titulo, descripcion, portada);
    }
    void establecerImagenSeleccionada(Uri uri){
        imagenSeleccionada.setValue(uri);
    }

}
