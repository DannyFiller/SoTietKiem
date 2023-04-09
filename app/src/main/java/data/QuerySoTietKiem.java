package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.sotietkiem.SignInActivity;

import InOut.MoneyInActivity;

public class QuerySoTietKiem {
    public static void insert(Context context, SoTietKiem soMoi)
    {
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(helper.COLUMN_ID_USER, SignInActivity.loginUser.getId());
        values.put(helper.COLUMN_NAME_SO,soMoi.getTenSo());
        values.put(helper.COLUMN_MONEY_SO,soMoi.getTienTietKiem());
        db.insert(helper.TABLE_NAME1,null,values);
        db.close();
    }
}
