package InOut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.sotietkiem.MainActivity;
import com.example.sotietkiem.R;
import com.example.sotietkiem.SignInActivity;

import java.text.DateFormat;
import java.util.Calendar;

import data.DataQuery;
import data.QuerySoTietKiem;
import data.SoTietKiem;

public class MoneyInActivity extends AppCompatActivity {

    Button btnGui;
    EditText edTen,edSodu,edGuiTien,edNoiDung;

    AutoCompleteTextView acKyHanView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_in);


        edTen = findViewById(R.id.edTenUser);
        edSodu = findViewById(R.id.edSodu);
        btnGui = findViewById(R.id.btnGui);
        edGuiTien = findViewById(R.id.edGuiTien);
        edNoiDung = findViewById(R.id.edNoiDung);

        edTen.setText(SignInActivity.loginUser.getUserName());
        edSodu.setText(String.valueOf(SignInActivity.loginUser.getMoney()));



        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.spinner1);
        //create a list of items for the spinner.
        String[] items = new String[]{"3 tháng", "6 tháng", "9 tháng"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);



        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String soTienGui = edGuiTien.getText().toString().trim();
                String noiDung = edNoiDung.getText().toString().trim();
                String daoHan = dropdown.getSelectedItem().toString();
                Calendar calendar = Calendar.getInstance();
                String curDate = DateFormat.getDateInstance().format(calendar.getTime());

                SoTietKiem SoMoi = new SoTietKiem(SignInActivity.loginUser.getId(),noiDung,Integer.parseInt(soTienGui),curDate,daoHan);


                if(Integer.parseInt(soTienGui) < SignInActivity.loginUser.getMoney())
                {
                    QuerySoTietKiem.insert(MoneyInActivity.this,SoMoi);
                    Tru();
                    Intent i = new Intent(MoneyInActivity.this,MainActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MoneyInActivity.this, "Tài khoản của bạn không đủ để gửi tiết kiệm", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    void Tru(){
        String sotien = edGuiTien.getText().toString();
        int a = Integer.parseInt(sotien);
        int b = SignInActivity.loginUser.getMoney();
        int c = b - a;
        SignInActivity.loginUser.setMoney(c);
        DataQuery.insertMoney(MoneyInActivity.this,SignInActivity.loginUser);
    }
}