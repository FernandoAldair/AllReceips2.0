package com.example.allreceips20.OtherList;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RecetaPublica{
    @PrimaryKey(autoGenerate = true)
    int id;
    String nombre;
    String descripcion;
    float valoracion;


    public RecetaPublica(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}