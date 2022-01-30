//package com.vhbeltramini.storageplus.database;
//
//
//import android.content.Context;
//
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//
//import com.vhbeltramini.storageplus.dao.AtributoDinamicoDao;
//import com.vhbeltramini.storageplus.model.AtributoDinamico;
//
//@Database(entities = {AtributoDinamico.class}, exportSchema = false, version = 1)
//public abstract class AtributoDinamicoDatabase extends RoomDatabase{
//
//    private static final String DB_NAME = "dbstorageplus";
//    private static AtributoDinamicoDatabase instance;
//
//    public static synchronized AtributoDinamicoDatabase getInstance(Context context) {
//        if (instance == null) {
//            instance = Room.databaseBuilder(context.getApplicationContext(), AtributoDinamicoDatabase.class, DB_NAME)
//                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
//        }
//        return instance;
//    }
//
//    public abstract AtributoDinamicoDao atributoDinamicoDao();
//
//}
