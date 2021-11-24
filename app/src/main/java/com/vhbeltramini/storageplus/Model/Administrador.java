package com.vhbeltramini.storageplus.Model;

import androidx.room.Entity;
import androidx.room.Ignore;

@Entity(tableName = "tbadministrador")
public class Administrador extends Usuario {

    @Ignore
    public Administrador(String nome, String senha, String email) {
        super(nome, senha, email);
    }

}
