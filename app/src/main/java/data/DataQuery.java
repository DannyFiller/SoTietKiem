package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.sotietkiem.fragment.HistoryFragment;

import java.util.ArrayList;

import InOut.NapActivity;

public class DataQuery {


    public static void insert(Context context, User user)
    {
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(helper.COLUMN_USERNAME,user.userName);
        values.put(helper.COLUMN_PASSWORD,user.password);
        db.insert(helper.TABLE_NAME,null,values);
        db.close();
    }

    public static void insertMoney(Context context,User user)
    {

        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("money", user.getMoney());
        db.update(helper.TABLE_NAME, values, "username=?", new String[]{user.getUserName()});
    }

    public static boolean delete(Context context , int id )
    {
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        int rs = sqLiteDatabase.delete(helper.TABLE_NAME,helper.COLUMN_ID+ "=?", new String[]{String.valueOf(id)});
        return (rs>0);
    }


    public static ArrayList<User> getAll(Context context)
    {
        ArrayList<User> lstUser = new ArrayList<>();
        DatabaseHandler userDataHelper = new DatabaseHandler(context);
        SQLiteDatabase db = userDataHelper.getReadableDatabase();
        Cursor cs = db.rawQuery("Select * from " + DatabaseHandler.TABLE_NAME,null);
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

    public static void GetUser(Context context, User loginUser) {
    }

    public User checkLogin(Context context,String name,String password)
    {
        User user;
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql="SELECT * from "+helper.TABLE_NAME+" WHERE "+helper.COLUMN_USERNAME+" = "+"'"+name+"'"+" AND "+helper.COLUMN_PASSWORD+" = "+"'"+password+"'";
        Cursor cs=db.rawQuery(sql,null);
        if (cs.moveToFirst())
        {
            int id = cs.getInt(0);
            String username = cs.getString(1);
            String pass = cs.getString(2);
            String money = cs.getString(3);
            user= new User(id,username,pass,money);
        }
        else {
            Toast.makeText(context, "Sai thong tin", Toast.LENGTH_SHORT).show();
            user= null;
        }
       return user;
    }
    public static User GetUser(Context context,String username,String password)
    {
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql="SELECT * from "+helper.TABLE_NAME+" WHERE "+helper.COLUMN_USERNAME+" = "+"'"+username+"'"+" AND "+helper.COLUMN_PASSWORD+" = "+"'"+password+"'";
        Cursor cs=db.rawQuery(sql,null);
        if(cs != null)
        {
            cs.moveToFirst();
        }

        User user = new User(cs.getInt(0),cs.getString(1),cs.getString(2));
        return  user;
    }

    public static User GetMoney(Context context,User user)
    {
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT * from "+helper.TABLE_NAME+" WHERE "+helper.COLUMN_USERNAME+" = "+"'"+user.getUserName()+"'";
        Cursor cs = db.rawQuery(sql,null);
        if(cs != null)
        {
            cs.moveToFirst();
        }
        User user1 = new User(cs.getInt(0),cs.getString(1),cs.getString(2),cs.getString(3));
        return  user1;
    }
}
