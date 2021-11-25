package com.vhbeltramini.storageplus.Model;

import androidx.room.Entity;

@Entity(tableName = "tbadministrador")
public class Administrador extends Usuario {

    public Administrador(String nome, String senha, String email) {
        super(nome, senha, email);
    }

}
