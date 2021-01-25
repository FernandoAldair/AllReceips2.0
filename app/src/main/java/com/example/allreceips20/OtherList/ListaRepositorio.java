package com.example.allreceips20.OtherList;

import java.util.ArrayList;
import java.util.List;

public class ListaRepositorio {
    List<RecetaPublica> recetaPublicas = new ArrayList<>();

    interface Callback {
        void cuandoFinalice(List<RecetaPublica> elementos);
    }

    ListaRepositorio(){
        recetaPublicas.add(new RecetaPublica("Elemento químico", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción química, en otras más simples. Pueden existir dos átomos de un mismo elemento con características distintas y, en el caso de que estos posean número másico distinto, pertenecen al mismo elemento pero en lo que se conoce como uno de sus isótopos."));
        recetaPublicas.add(new RecetaPublica("Elemento de un conjunto", "En teoría de conjuntos, un elemento o miembro de un conjunto (o familia de conjuntos) es un objeto que forma parte de ese conjunto (o familia)."));
        recetaPublicas.add(new RecetaPublica("Elemento sintético", "En química, un elemento sintético es un elemento químico que no aparece de forma natural en la Tierra, y solo puede ser creado artificialmente."));
        recetaPublicas.add(new RecetaPublica("Elemento algebraico", "En matemáticas, más concretamente en álgebra abstracta y teoría de cuerpos, se dice que un elemento es algebraico sobre un cuerpo si es raíz de algún polinomio con coeficientes en dicho cuerpo. Los elementos algebraicos sobre el cuerpo de los números racionales reciben el nombre de números algebraicos."));
        recetaPublicas.add(new RecetaPublica("Elementos de la naturaleza","Los cuatro o cinco elementos de la naturaleza —normalmente agua, tierra, fuego y aire, a los que se añade la quintaesencia o éter— eran, para muchas doctrinas antiguas, los constituyentes básicos de la materia y explicaban el comportamiento de la naturaleza. El modelo estuvo vigente hasta que la ciencia moderna empezó a desentrañar los elementos y reacciones químicas."));
        recetaPublicas.add(new RecetaPublica("Elemento constructivo","Un elemento constructivo es cada uno de los componentes materiales que integran una obra de construcción. Se suelen clasificar en estructurales y compartimentadores."));
    }

    List<RecetaPublica> obtener() {
        return recetaPublicas;
    }

    void insertar(RecetaPublica elemento, Callback callback){
        recetaPublicas.add(elemento);
        callback.cuandoFinalice(recetaPublicas);
    }

    void eliminar(RecetaPublica elemento, Callback callback) {
        recetaPublicas.remove(elemento);
        callback.cuandoFinalice(recetaPublicas);
    }

    void actualizar(RecetaPublica elemento, float valoracion, Callback callback) {
        elemento.valoracion = valoracion;
        callback.cuandoFinalice(recetaPublicas);
    }
}
