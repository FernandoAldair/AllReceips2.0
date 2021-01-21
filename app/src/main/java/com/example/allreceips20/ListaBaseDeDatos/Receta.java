package com.example.allreceips20.ListaBaseDeDatos;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Receta{
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String titulo;
    public String descripcion;
    public String portada;

    public Receta(String titulo, String descripcion, String portada) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.portada = portada;
    }
}
