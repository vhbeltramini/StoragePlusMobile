//package com.vhbeltramini.storageplus.database;
//
//
//import android.content.Context;
//
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//
//import com.vhbeltramini.storageplus.dao.FuncionarioDao;
//import com.vhbeltramini.storageplus.model.Funcionario;
//
//@Database(entities = {Funcionario.class}, exportSchema = false, version = 1)
//public abstract class FuncionarioDatabase extends RoomDatabase{
//
//    private static final String DB_NAME = "dbstorageplus";
//    private static FuncionarioDatabase instance;
//
//    public static synchronized FuncionarioDatabase getInstance(Context context) {
//        if (instance == null) {
//            instance = Room.databaseBuilder(context.getApplicationContext(), FuncionarioDatabase.class, DB_NAME)
//                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
//        }
//        return instance;
//    }
//
//    public abstract FuncionarioDao funcionarioDao();
//
//}
