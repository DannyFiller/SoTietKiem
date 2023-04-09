package data;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.sotietkiem.fragment.HistoryFragment;

import java.util.ArrayList;
import java.util.List;

import InOut.NapActivity;

public class DataQuery {


    public static void insertUser(Context context, User user)
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

    public User  UpdateMoney(Context context,User user)
    {
        User user1 = null;
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("money", user.getMoney());
        String sql="SELECT * from "+helper.TABLE_NAME+" WHERE "+helper.COLUMN_USERNAME+" = "+"'"+user.userName+"'"+" AND "+helper.COLUMN_PASSWORD+" = "+"'"+ user.password+"'";
        Cursor cs=db.rawQuery(sql,null);
        if (cs.moveToFirst())
        {
            int id = cs.getInt(0);
            int money = cs.getInt(1);
            user1= new User(id,money);
        }
        return user1;
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





}
