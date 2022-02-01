package com.vhbeltramini.storageplus.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.vhbeltramini.storageplus.dao.CategoriaDao;
import com.vhbeltramini.storageplus.model.Categoria;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Categoria.class}, version = 1)
public abstract class CategoriaDatabase extends RoomDatabase {

    public abstract CategoriaDao categoriaDao();
    private static final String DB_NAME = "dbstorageplus";
    private static CategoriaDatabase instance;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public static synchronized CategoriaDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), CategoriaDatabase.class, DB_NAME)
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }

}
