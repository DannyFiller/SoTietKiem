package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.widget.Toast;

import com.example.sotietkiem.SignInActivity;

import java.util.ArrayList;

public class DataQuery {


    public static long insertUser(Context context, User user)
    {
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utils.COLUMN_USERNAME,user.userName);
        values.put(Utils.COLUMN_PASSWORD,user.password);
        values.put(Utils.COLUMN_PHONE,user.phoneNumber);
        values.put(Utils.COLUMN_GMAIL,user.email);
        values.put(Utils.COLUMN_MONEY,50);
        long rs = db.insert(Utils.TABLE_NAME,null,values);
        return rs;

    }

    public static void insertMoney(Context context,User user)
    {
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("money", user.getMoney());
        db.update(Utils.TABLE_NAME, values, "username=?", new String[]{user.getUserName()});
    }

    public static void UpdateName(Context context,User user)
    {
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", user.getUserName());
        db.update(Utils.TABLE_NAME, values, "id=?", new String[]{String.valueOf(user.getId())});
    }

    public static void UpdateGmail(Context context,User user)
    {
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("gmail", user.getEmail());
        db.update(Utils.TABLE_NAME, values, "id=?", new String[]{String.valueOf(user.getId())});
    }

    public static void UpdatePhone(Context context,User user)
    {
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("phone", user.getPhoneNumber());
        db.update(Utils.TABLE_NAME, values, "id=?", new String[]{String.valueOf(user.getId())});
    }

//    public static void UpdateName(Context context,User user)
//    {
//        DatabaseHandler helper = new DatabaseHandler(context);
//        SQLiteDatabase db = helper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("name", user.getUserName());
//        db.update(Utils.TABLE_NAME, values, "username=?", new String[]{user.getUserName()});
//    }

//    public User  UpdateMoney(Context context,User user)
//    {
//        User user1 = null;
//        DatabaseHandler helper = new DatabaseHandler(context);
//        SQLiteDatabase db = helper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("money", user.getMoney());
//        String sql="SELECT * from "+Utils.TABLE_NAME+" WHERE "+Utils.COLUMN_USERNAME+" = "+"'"+user.userName+"'"+" AND "+Utils.COLUMN_PASSWORD+" = "+"'"+ user.password+"'";
//        Cursor cs=db.rawQuery(sql,null);
//        if (cs.moveToFirst())
//        {
//            int id = cs.getInt(0);
//            String username = cs.getString(1);
//            String pass = cs.getString(2);
//            int phone = cs.getInt(3);
//            String gmail = cs.getString(4);
//            int money = cs.getInt(5);
//
//            user1= new User(id, username, pass, money, gmail, money);
//        }
//        return user1;
//    }


    public static ArrayList<User> getAll(Context context)
    {
        ArrayList<User> lstUser = new ArrayList<>();
        DatabaseHandler userDataHelper = new DatabaseHandler(context);
        SQLiteDatabase db = userDataHelper.getReadableDatabase();
        Cursor cs = db.rawQuery("Select * from " + Utils.TABLE_NAME,null);
        cs.moveToFirst();
        while (!cs.isAfterLast())
        {
            int id = cs.getInt(0);
            String name = cs.getString(1);
            String password = cs.getString(2);
            lstUser.add(new User(id,name,password));
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return lstUser;
    }

    public User checkLogin(Context context,String name,String password)
    {
        User user;
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql="SELECT * from "+Utils.TABLE_NAME+" WHERE "+Utils.COLUMN_USERNAME+" = "+"'"+name+"'"+" AND "+Utils.COLUMN_PASSWORD+" = "+"'"+password+"'";
        Cursor cs=db.rawQuery(sql,null);
        if (cs != null)
        {
            cs.moveToFirst();
            int id = cs.getInt(0);
            String username = cs.getString(1);
            String pass = cs.getString(2);
            int phone = cs.getInt(3);
            String gmail = cs.getString(4);
            int money = cs.getInt(5);
            user= new User(id,username,pass,phone,gmail,money);
        }
        else {
            Toast.makeText(context, "Sai thong tin", Toast.LENGTH_SHORT).show();
            user= null;
        }
       return user;
    }





}
