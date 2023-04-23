package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.sotietkiem.SignInActivity;
import com.example.sotietkiem.fragment.ListFragment;

import java.util.ArrayList;

import InOut.MoneyInActivity;

public class QuerySoTietKiem {
    public static void insert(Context context, SoTietKiem soMoi)
    {
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utils.COLUMN_ID_USER, SignInActivity.loginUser.getId());
        values.put(Utils.COLUMN_NAME_SO,soMoi.getTenSo());
        values.put(Utils.COLUMN_MONEY_SO,soMoi.getTienTietKiem());
        values.put(Utils.COLUMN_DATE,soMoi.getDate());
        values.put(Utils.COLUMN_DAOHAN,soMoi.getDaoHan());
        db.insert(Utils.TABLE_NAME1,null,values);
        db.close();
    }

    public static void updateMoneySTK(Context context,int id)
    {
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("soTien", ListFragment.curList.getTienTietKiem());
        db.update(Utils.TABLE_NAME1, values, "id=?", new String[]{String.valueOf(id)});
    }

//    public static void OutMoney(Context context,SoTietKiem stk)
//    {
//        DatabaseHandler helper = new DatabaseHandler();
//        SQLiteDatabase db = helper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(Utils.COLUMN_MONEY_SO,);
//        }
//    }

    public static ArrayList<SoTietKiem> ListSoTietKiem(Context context, User user)
    {
        ArrayList<SoTietKiem> lstStk = new ArrayList<>();
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql="SELECT * from "+Utils.TABLE_NAME1+" WHERE "
                +Utils.COLUMN_ID_USER
                +" = "
                +user.getId()
                +";";
        Cursor cs=db.rawQuery(sql,null);
        cs.moveToFirst();
        while (!cs.isAfterLast())
        {
            int id = cs.getInt(0);
            int idUser = cs.getInt(1);
            String tenSo = cs.getString(2);
            int tienStk = cs.getInt(3);
            String daoHan = cs.getString(4);
            String date = cs.getString(5);

            lstStk.add(new SoTietKiem(id,idUser,tenSo,tienStk,date,daoHan));
            cs.moveToNext();
        }
        cs.close();
        return lstStk;
    }

    public static ArrayList<String> ListTenSoTietKiem(Context context, User user)
    {
        ArrayList<SoTietKiem> lstStk = new ArrayList<>();
        ArrayList<String> listTen = new ArrayList<>();
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql="SELECT * from "+Utils.TABLE_NAME1+" WHERE "
                +Utils.COLUMN_ID_USER
                +" = "
                +user.getId()
                +";";
        Cursor cs=db.rawQuery(sql,null);
        cs.moveToFirst();
        while (!cs.isAfterLast())
        {
            int id = cs.getInt(0);
            int idUser = cs.getInt(1);
            String tenSo = cs.getString(2);
            int tienStk = cs.getInt(3);
            String daoHan = cs.getString(4);
            String date = cs.getString(5);

            lstStk.add(new SoTietKiem(id,idUser,tenSo,tienStk,date,daoHan));
            listTen.add(tenSo);
            cs.moveToNext();
        }
        cs.close();
        return listTen;
    }

    public static boolean delete(Context context , int id )
    {
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        int rs = sqLiteDatabase.delete(Utils.TABLE_NAME1,Utils.COLUMN_ID_SOTIETKIEM+ "=?", new String[]{String.valueOf(id)});
        return (rs>0);
    }
}
