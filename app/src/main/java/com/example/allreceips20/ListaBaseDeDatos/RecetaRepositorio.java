package com.example.allreceips20.ListaBaseDeDatos;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RecetaRepositorio {
    Executor executor = Executors.newSingleThreadExecutor();
    BaseDeDatos.RecetaDao recetaDao;

    public RecetaRepositorio(Application application) {
        recetaDao = BaseDeDatos.getInstance(application).obetenerRecetaDao();
    }

    LiveData<List<Receta>> obtenerReceta() {
        return recetaDao.obtenerReceta();
    }

    void insertarReceta(String titulo, String descripcion, String portada) {
        executor.execute(() -> {
            recetaDao.insertarReceta(new Receta(titulo, descripcion, portada));
        });
    }
}
