package com.example.allreceips20.OtherList;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Update;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.List;

@Database(entities = { RecetaPublica.class }, version = 2, exportSchema = false)

public abstract class BaseDeDatos2 extends RoomDatabase {

    private static volatile BaseDeDatos2 INSTANCIA;

    public abstract RecetaPublicaDao obtenerElementosDao();

    static BaseDeDatos2 obtenerInstancia(final Context context) {
        if (INSTANCIA == null) {
            synchronized (BaseDeDatos2.class) {
                if (INSTANCIA == null) {
                    INSTANCIA = Room.databaseBuilder(context,
                            BaseDeDatos2.class, "elementos.db")
                            .fallbackToDestructiveMigration()
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);

                                }
                            })
                            .build();
                }
            }
        }
        return INSTANCIA;
    }

    @Dao
    interface RecetaPublicaDao {
        @Query("SELECT * FROM RecetaPublica")
        LiveData<List<RecetaPublica>> obtener();

        @Insert
        void insertar(RecetaPublica elemento);

        @Update
        void actualizar(RecetaPublica elemento);

        @Delete
        void eliminar(RecetaPublica elemento);

        @Query("SELECT * FROM RecetaPublica ORDER BY valoracion DESC")
        LiveData<List<RecetaPublica>> masValorados();

        @Query("SELECT * FROM RecetaPublica WHERE nombre LIKE '%' || :d || '%'")
        LiveData<List<RecetaPublica>> buscar(String d);
    }
}
