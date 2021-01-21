package com.example.allreceips20.ListaBaseDeDatos;

import android.content.Context;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;


@Database(entities = {Receta.class}, version = 1, exportSchema = false)
public abstract class BaseDeDatos extends RoomDatabase {
    private static volatile BaseDeDatos db;

    public abstract RecetaDao obetenerRecetaDao();

    public static BaseDeDatos getInstance(final Context context){

        if (db == null){
            synchronized (BaseDeDatos.class){
                if (db == null){
                    db = Room.databaseBuilder(context, BaseDeDatos.class, "app.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return db;
    }
    @Dao
    public interface RecetaDao {
        @Insert
        void insertarReceta(Receta receta);

        @Query("SELECT * FROM Receta")
        LiveData<List<Receta>> obtenerReceta();
    }
}
