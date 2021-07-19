package ir.sarasaghaei.instagram_adv04.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import ir.sarasaghaei.instagram_adv04.Const;
import ir.sarasaghaei.instagram_adv04.entity.User;

class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, Const.DB_NAME, null, Const.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { CreateTable_User(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void CreateTable_User(SQLiteDatabase db){

        String query = "CREATE TABLE "+ User.class.getSimpleName() +" (\n " +
                "    id  integer primary key ,\n" +
                "    id_user  integer ,\n" +
                "    name nvarchar(50),\n" +
                "    pic_user integer(100),\n" +
                "    detail nvarchar(200),\n" +
                "    id_post integer ,\n" +
                "    link_post1 integer(100),\n" +
                "    link_post2 integer(100),\n" +
                "    link_post3 integer(100),\n" +
                "    detail_post text,\n" +
                "    fallow integer,\n" +
                "    like_post integer); ";


        try {
            db.execSQL(query);
        }
        catch (Exception ex){
            Log.e("TAG", "CreateTable_User: " + ex.getMessage());

        }
    }
}
