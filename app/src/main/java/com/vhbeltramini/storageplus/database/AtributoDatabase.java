package com.vhbeltramini.storageplus.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.vhbeltramini.storageplus.dao.AtributoDao;
import com.vhbeltramini.storageplus.model.Atributo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Atributo.class}, version = 1)
public abstract class AtributoDatabase extends RoomDatabase{

    public abstract AtributoDao atributoDao();
    private static final String DB_NAME = "dbstorageplus";
    private static AtributoDatabase instance;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized AtributoDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AtributoDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }


}
