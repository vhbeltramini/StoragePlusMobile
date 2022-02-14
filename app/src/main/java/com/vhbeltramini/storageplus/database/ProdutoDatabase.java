package com.vhbeltramini.storageplus.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.vhbeltramini.storageplus.dao.ProdutoDao;
import com.vhbeltramini.storageplus.model.Produto;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Produto.class}, version = 1)
public abstract class ProdutoDatabase extends RoomDatabase {

    public abstract ProdutoDao produtoDao();
    private static final String DB_NAME = "dbstorageplus";
    private static ProdutoDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized ProdutoDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ProdutoDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

}
