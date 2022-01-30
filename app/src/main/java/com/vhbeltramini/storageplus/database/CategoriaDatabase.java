//package com.vhbeltramini.storageplus.database;
//
//
//import android.content.Context;
//
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//
//import com.vhbeltramini.storageplus.dao.CategoriaDao;
//import com.vhbeltramini.storageplus.model.Categoria;
//
//@Database(entities = {Categoria.class}, exportSchema = false, version = 1)
//public abstract class CategoriaDatabase extends RoomDatabase{
//
//    private static final String DB_NAME = "dbstorageplus";
//    private static CategoriaDatabase instance;
//
//    public static synchronized CategoriaDatabase getInstance(Context context) {
//        if (instance == null) {
//            instance = Room.databaseBuilder(context.getApplicationContext(), CategoriaDatabase.class, DB_NAME)
//                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
//        }
//        return instance;
//    }
//
//    public abstract CategoriaDao categoriaDao();
//
//}
