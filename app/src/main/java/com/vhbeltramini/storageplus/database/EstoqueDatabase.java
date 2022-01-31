package com.vhbeltramini.storageplus.database;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.vhbeltramini.storageplus.dao.EstoqueDao;
import com.vhbeltramini.storageplus.model.Estoque;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Estoque.class}, exportSchema = false, version = 2)
public abstract class EstoqueDatabase extends RoomDatabase{

    public abstract EstoqueDao estoqueDao();

    private static final String DB_NAME = "dbstorageplus";
    private static EstoqueDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized EstoqueDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), EstoqueDatabase.class, DB_NAME)
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                EstoqueDao dao = INSTANCE.estoqueDao();
                dao.deleteAll();

                Estoque estoque = new Estoque("Estoque 1", "Estoque de Agua");
                dao.insert(estoque);
                estoque = new Estoque("Estoque 1", "Estoque de Vento");
                dao.insert(estoque);
            });
        }
    };

}
