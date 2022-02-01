package com.vhbeltramini.storageplus.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.vhbeltramini.storageplus.dao.AtributoDinamicoDao;
import com.vhbeltramini.storageplus.model.AtributoDinamico;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {AtributoDinamico.class}, version = 1)
public abstract class AtributoDinamicoDatabase extends RoomDatabase{

    private static final String DB_NAME = "dbstorageplus";
    private static AtributoDinamicoDatabase instance;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized AtributoDinamicoDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AtributoDinamicoDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract AtributoDinamicoDao atributoDinamicoDao();

}
