package com.example.allreceips20.OtherList;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ListaRepositorio {

    BaseDeDatos2.RecetaPublicaDao recetaPublicaDao;
    Executor executor = Executors.newSingleThreadExecutor();

    ListaRepositorio(Application application){
        recetaPublicaDao = BaseDeDatos2.obtenerInstancia(application).obtenerElementosDao();
    }

    LiveData<List<RecetaPublica>> obtener(){
        return recetaPublicaDao.obtener();
    }

    LiveData<List<RecetaPublica>> masValorados() {
        return recetaPublicaDao.masValorados();
    }

    LiveData<List<RecetaPublica>> buscar(String d) {
        return recetaPublicaDao.buscar(d);
    }


    void insertar(RecetaPublica elemento){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                recetaPublicaDao.insertar(elemento);
            }
        });
    }

    void eliminar(RecetaPublica elemento) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                recetaPublicaDao.eliminar(elemento);
            }
        });
    }

    public void actualizar(RecetaPublica elemento, float valoracion) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                elemento.valoracion = valoracion;
                recetaPublicaDao.actualizar(elemento);
            }
        });
    }
}