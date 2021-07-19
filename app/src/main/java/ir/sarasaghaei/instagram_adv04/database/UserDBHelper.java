package ir.sarasaghaei.instagram_adv04.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import ir.sarasaghaei.instagram_adv04.R;
import ir.sarasaghaei.instagram_adv04.entity.User;

public class UserDBHelper extends DBHelper {

    public Context context;
    private final String TABLE_NAME = User.class.getSimpleName();
    private final String FILD_Id_user = "id_user" , FILD_Name = "name", FILD_Pic_user ="pic_user",
            FILD_Detail = "detail", FILD_Id_post ="id_post", FILD_Detail_post ="detail_post",
            FILD_Link_post1 ="link_post1", FILD_Link_post2 ="link_post2", FILD_Link_post3 ="link_post3",
            FILD_Fallow = "fallow" , FILD_Like_post = "like_post";

    public UserDBHelper(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insert(User user_record)
    {
        long result = -1;
        try (SQLiteDatabase db = this.getWritableDatabase()) {
            ContentValues cv = new ContentValues();
            cv.put(FILD_Id_user, user_record.getId_user());
            cv.put(FILD_Name, user_record.getName());
            cv.put(FILD_Pic_user, user_record.getPic_user());
            cv.put(FILD_Detail, user_record.getDetail());
            cv.put(FILD_Id_post, user_record.getId_post());
            cv.put(FILD_Detail_post, user_record.getDetail_post());
            cv.put(FILD_Link_post1, user_record.getLink_post1());
            cv.put(FILD_Link_post2, user_record.getLink_post2());
            cv.put(FILD_Link_post3, user_record.getLink_post3());
            cv.put(FILD_Fallow, user_record.getFallow());
            cv.put(FILD_Like_post, user_record.getLike_post());

            result = db.insert(TABLE_NAME, null, cv);


        } catch (Exception ex) {
            Log.e("TAG", "insert: " + ex.getMessage() );

        }
        return result;
    }

    public List<User> select_user(){
        List<User> result = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] Columns = { FILD_Id_user,FILD_Name,FILD_Pic_user,FILD_Detail};
        Cursor cursor = db.query(TABLE_NAME,Columns,null,null,null,null,null);

        cursor.getCount();
        while (cursor.moveToNext()){
            int id_user = cursor.getInt(cursor.getColumnIndex(FILD_Id_user));
            String name = cursor.getString(cursor.getColumnIndex(FILD_Name));
            int pic_user = cursor.getInt(cursor.getColumnIndex(FILD_Pic_user));
            String detail = cursor.getString(cursor.getColumnIndex(FILD_Detail));

            User user = new User(id_user,name,pic_user,detail);

            result.add(user);
        }
        cursor.close();
        db.close();
        return result;
    }

    public User select_user(int id_user){
        SQLiteDatabase db = this.getReadableDatabase();

        User user = null;
        String[] Columns = { FILD_Id_user,FILD_Name,FILD_Pic_user,FILD_Detail};
        Cursor cursor = db.query(TABLE_NAME,Columns,"id_user=?",new String[]{String.valueOf(id_user)},null,null,null);

        cursor.getCount();
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(FILD_Name));
            int pic_user = cursor.getInt(cursor.getColumnIndex(FILD_Pic_user));
            String detail = cursor.getString(cursor.getColumnIndex(FILD_Detail));

             user = new User(id_user,name,pic_user,detail);

        }
        cursor.close();
        db.close();
        return user;
    }

    public boolean isEmpty(){

        boolean empty = true;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cur = db.rawQuery("SELECT COUNT(*) FROM " + TABLE_NAME, null);
        if (cur != null && cur.moveToFirst()) {
            empty = (cur.getInt (0) == 0);
        }
        if (cur != null) {
            cur.close();
        }

        return empty;
    }
    public void First_loade() {
        long ok = -1;
        List<User> result;
        result = import_data();
        for (int i = 0; i < result.size(); i++) {

            User new_record =result.get(i);
            try {
                ok = insert(new_record);
            }catch (Exception ex){
                Log.e("TAG", "First_loade: " + ex.getMessage() );

            }


        }
    }

    public List<User> select_post(){
        List<User> result = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] Columns = { FILD_Id_user,FILD_Name,FILD_Pic_user,FILD_Detail,FILD_Id_post,FILD_Detail_post,
                FILD_Link_post1, FILD_Link_post2, FILD_Link_post3,FILD_Fallow,FILD_Like_post };
        Cursor cursor = db.query(TABLE_NAME,Columns,"id_post>0",null,null,null,null);

        if(cursor.getCount() == 0)
        {

        }
        while (cursor.moveToNext()){
            int id_user = cursor.getInt(cursor.getColumnIndex(FILD_Id_user));
            String name = cursor.getString(cursor.getColumnIndex(FILD_Name));
            int pic_user = cursor.getInt(cursor.getColumnIndex(FILD_Pic_user));
            String detail = cursor.getString(cursor.getColumnIndex(FILD_Detail));
            int id_post = cursor.getInt(cursor.getColumnIndex(FILD_Id_post));
            String detailpost = cursor.getString(cursor.getColumnIndex(FILD_Detail_post));
            int linkpost1 = cursor.getInt(cursor.getColumnIndex(FILD_Link_post1));
            int linkpost2 = cursor.getInt(cursor.getColumnIndex(FILD_Link_post2));
            int linkpost3 = cursor.getInt(cursor.getColumnIndex(FILD_Link_post3));
            int fallow = cursor.getInt(cursor.getColumnIndex(FILD_Fallow));
            int likepost = cursor.getInt(cursor.getColumnIndex(FILD_Like_post));

            User user = new User(id_user,name,pic_user,detail,
                    id_post,linkpost1,linkpost2,linkpost3,detailpost,fallow,likepost);

            result.add(user);
        }
        cursor.close();
        db.close();
        return result;
    }

    public List<User> select_post(int id_user){
        List<User> result = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] Columns = {FILD_Id_user,FILD_Name,FILD_Pic_user,FILD_Detail,FILD_Id_post,FILD_Detail_post,
                FILD_Link_post1, FILD_Link_post2, FILD_Link_post3,FILD_Fallow,FILD_Like_post };
        Cursor cursor = db.query(TABLE_NAME,Columns,"id_user=? AND id_post>0",new String[]{String.valueOf(id_user)},null,null,null);

        if(cursor.getCount() == 0)
        {

        }
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(FILD_Name));
            int pic_user = cursor.getInt(cursor.getColumnIndex(FILD_Pic_user));
            String detail = cursor.getString(cursor.getColumnIndex(FILD_Detail));
            int id_post = cursor.getInt(cursor.getColumnIndex(FILD_Id_post));
            String detailpost = cursor.getString(cursor.getColumnIndex(FILD_Detail_post));
            int linkpost1 = cursor.getInt(cursor.getColumnIndex(FILD_Link_post1));
            int linkpost2 = cursor.getInt(cursor.getColumnIndex(FILD_Link_post2));
            int linkpost3 = cursor.getInt(cursor.getColumnIndex(FILD_Link_post3));
            int fallow = cursor.getInt(cursor.getColumnIndex(FILD_Fallow));
            int likepost = cursor.getInt(cursor.getColumnIndex(FILD_Like_post));

            User user = new User(id_user,name,pic_user,detail,
                    id_post,linkpost1,linkpost2,linkpost3,detailpost,fallow,likepost);

            result.add(user);
        }
        cursor.close();
        db.close();
        return result;
    }

    public int updatelikedpost(int id_post, int num_likepost){

        SQLiteDatabase db_update = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(FILD_Like_post, num_likepost);
        int result = -1;
        try {
            result = db_update.update(TABLE_NAME, cv, "id_post=?", new String[]{String.valueOf(id_post)});


        } catch (Exception ex) {
        }
        db_update.close();
        return num_likepost;
    }

    public List<User> import_data(){
        List<User> data_user = new ArrayList<>();
        data_user.add(new User(1,"sara", R.drawable.user7,"saraaaaaaa",6,R.drawable.car1,
                0, 0,"ssssssssss",0,2) );
        data_user.add(new User(2,"reza", R.drawable.user2,
                "rrrrrrrrrrrrrrrr",5 , R.drawable.car2,0 ,0 ,
                "caaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaar", 0 , 2));

        data_user.add(new User(4,"saba", R.drawable.user4,
                "sssssssssssssssss",8,R.drawable.sear,0 ,0 ,
                "", 0 , 0));
        data_user.add(new User(4,"saba", R.drawable.user4,
                "sssssssssssssssss",25,R.drawable.j,0 ,0 ,
                "", 0 , 0));
        data_user.add(new User(4,"saba", R.drawable.user4,
                "sssssssssssssssss",26,R.drawable.sea,0 ,0 ,
                "", 0 , 0));
        data_user.add(new User(4,"saba", R.drawable.user5,
                "sssssssssssssssss",29,R.drawable.pic1,0 ,0 ,
                "", 0 , 0));
        data_user.add(new User(3,"asal", R.drawable.user3,
                "aaaaaaaaaaaaaaaaaaaa",4,R.drawable.pic2,0 ,0 ,
                "seaaaaa", 0 , 2));

        data_user.add(new User(5,"hadi", R.drawable.user1,
                "hhhhhhhhhhhhhhhhhhh",0,0,0 ,0 ,
                "", 0 , 0));
        data_user.add(new User(6,"taha", R.drawable.user6,
                "tttttttttttt",11,R.drawable.pic3,0 ,0 ,
                "", 0 , 0));
        return data_user;

    }
}
