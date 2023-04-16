package com.example.sotietkiem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import data.DataQuery;
import data.DatabaseHandler;
import data.User;

public class SignInActivity extends AppCompatActivity {
    EditText edTaiKhoan, edPassword;
    Button btDangNhap,btDangKy;

    TextView tvTest;

    ArrayList<User> lstUser;



    public static User loginUser;
//    SharedPreferences.Editor editor;
//    private final Gson gson =new Gson();
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

//        sharedPreferences = getSharedPreferences(Utils.SHARE_PREFERENCES_APP, Context.MODE_PRIVATE);
//        editor = sharedPreferences.edit();

       anhxa();

       btDangNhap.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {


//               lstUser = DataQuery.getAll(SignInActivity.this);

               DatabaseHandler helper = new DatabaseHandler(SignInActivity.this);
               SQLiteDatabase db = helper.getWritableDatabase();
//               String username = edTaiKhoan.getText().toString().trim();
//               String password = edPassword.getText().toString().trim();

              checkUserLogin();
           }
       });

        btDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
    }

    void anhxa(){
        btDangNhap = findViewById(R.id.btDangNhap);

        edTaiKhoan = findViewById(R.id.edUserNameLo);
        edPassword = findViewById(R.id.edPaswordLo);

        btDangKy = findViewById(R.id.btDangKy);
    }

    private void checkUserLogin() {
        DataQuery query=new DataQuery();
        loginUser=query.checkLogin(this,edTaiKhoan.getText().toString(),edPassword.getText().toString());
        if (loginUser != null)
        {
            Toast.makeText(SignInActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(SignInActivity.this, "Dang nhap that bai", Toast.LENGTH_SHORT).show();
        }
    }
}