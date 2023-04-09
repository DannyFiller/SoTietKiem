package InOut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;


import com.example.sotietkiem.MainActivity;
import com.example.sotietkiem.R;
import com.example.sotietkiem.SignInActivity;

public class MoneyInActivity extends AppCompatActivity {

    Button btnGui;
    EditText edTen,edSodu,edGuiTien;

    AutoCompleteTextView acKyHanView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_in);

        edTen = findViewById(R.id.edTenUser);
        edSodu = findViewById(R.id.edSodu);
        btnGui = findViewById(R.id.btnGui);
        edGuiTien = findViewById(R.id.edGuiTien);

        edTen.setText(SignInActivity.loginUser.getUserName());
        edSodu.setText(String.valueOf(SignInActivity.loginUser.getMoney()));
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String soTienGui = edGuiTien.getText().toString().trim();

                Intent i = new Intent(MoneyInActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}