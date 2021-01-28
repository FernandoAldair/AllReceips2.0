package com.example.allreceips20.model;

import android.content.Context;


import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


@Database(entities = {Receta.class}, version = 2, exportSchema = false)
public abstract class BaseDeDatos extends RoomDatabase {
    private static volatile BaseDeDatos db;

    static Executor executor = Executors.newSingleThreadExecutor();

    public abstract RecetaDao obetenerRecetaDao();

    public static BaseDeDatos getInstance(final Context context){

        if (db == null){
            synchronized (BaseDeDatos.class){
                if (db == null){
                    db = Room.databaseBuilder(context, BaseDeDatos.class, "app.db")
                            .fallbackToDestructiveMigration()
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);

                                    insertarDatosIniciales(getInstance(context).obetenerRecetaDao());
                                }

                                @Override
                                public void onDestructiveMigration(@NonNull SupportSQLiteDatabase db) {
                                    super.onDestructiveMigration(db);

                                    insertarDatosIniciales(getInstance(context).obetenerRecetaDao());
                                }
                            })
                            .build();
                }
            }
        }
        return db;
    }

    private static void insertarDatosIniciales(RecetaDao dao) {
        executor.execute(() -> {
            dao.insertarReceta(new Receta("dsasda", "dasads","file:///android_asset/1.jpg",1));
            dao.insertarReceta(new Receta("dsaaasdasda", "dasads","file:///android_asset/2.jpg",1));
            dao.insertarReceta(new Receta("dsdasasdasdasda", "dasads","file:///android_asset/10.jpg",1));
//            dao.insertarReceta(new Receta());
//            dao.insertarReceta(new Receta());
        });
    }

    @Dao
    public interface RecetaDao {
        @Insert
        void insertarReceta(Receta receta);

        @Query("SELECT * FROM Receta WHERE lista = 0")
        LiveData<List<Receta>> obtenerRecetas();

        @Query("SELECT * FROM Receta WHERE lista = 1")
        LiveData<List<Receta>> obtenerRecetasIniciales();

    }
}
