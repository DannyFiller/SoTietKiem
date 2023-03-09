package com.example.doan;

import static com.example.doan.R.id.btDangKy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Database.DatabaseHandler;
import Database.User;


public class SigninActivity extends AppCompatActivity {


    EditText edTaiKhoan, edPassword;
    Button btDangNhap,btDangKy;

    TextView tvTest;

    DatabaseHandler helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        SQLiteDatabase db = helper.getReadableDatabase();

//        setContentView(R.layout.activity_signin);


        btDangNhap = findViewById(R.id.btDangNhap);

        edTaiKhoan = findViewById(R.id.edTaiKhoan);
        edPassword = findViewById(R.id.edPassword);

        btDangKy = findViewById(R.id.btDangKy);

        tvTest = findViewById(R.id.tvTest);







        btDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edTaiKhoan.getText().toString();
                String password = edPassword.getText().toString();


                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "vui lòng nhập thông tin đầy đủ", Toast.LENGTH_LONG).show();}
                else
                {

                    Intent i = new Intent(SigninActivity.this, MainActivity.class);
                    i.putExtra("usename",username);
                    startActivity(i);
                }
            }
        });

        btDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SigninActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
    }

}