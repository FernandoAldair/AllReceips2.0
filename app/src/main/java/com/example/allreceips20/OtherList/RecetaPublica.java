package com.example.allreceips20.OtherList;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RecetaPublica{
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String titulo;
    public String descripcion;
    public String portada;
    public int tiempo;
    float valoracion;

    public RecetaPublica(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
}