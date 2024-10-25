package com.example.pet;

import java.util.ArrayList;
import java.util.List;

public class DadosCompartilhados {
    public static String usuarioLogado = "";
    public static List<Pet> lista = new ArrayList<Pet>();
    private static Integer idPet = 0;

    public static Integer getNextId(){
        idPet = idPet + 1;
        return idPet;
    }
}
