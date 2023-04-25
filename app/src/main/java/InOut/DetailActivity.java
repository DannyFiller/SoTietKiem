package InOut;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sotietkiem.ListAdapter;
import com.example.sotietkiem.MainActivity;
import com.example.sotietkiem.R;
import com.example.sotietkiem.SignInActivity;
import com.example.sotietkiem.fragment.HomeFragment;
import com.example.sotietkiem.fragment.ListFragment;

import org.w3c.dom.Text;

import data.DataQuery;
import data.QuerySoTietKiem;
import data.SoTietKiem;

public class DetailActivity extends AppCompatActivity {

    TextView tvTen,tvTien,tvKyHan,tvNgayGui ;
    Button btnGuiStk,btnRutStk,btnXoaStk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTen = findViewById(R.id.tvTenStkDetail);
        tvTien = findViewById(R.id.tvSoTienTietkiem);
        tvKyHan = findViewById(R.id.tvKyHan);
        tvNgayGui = findViewById(R.id.tvNgayGui);

        Bundle goi = getIntent().getExtras();
        String ten =goi.getString("ten");
        String tien =goi.getString("tien");
        String kyHan = goi.getString("han");
        String date = goi.getString("date");




        tvTen.setText(ten);
        tvTien.setText(tien +" VND");
        tvKyHan.setText(kyHan);
        tvNgayGui.setText(date);




        btnGuiStk=findViewById(R.id.btnNapStk);
        btnRutStk=findViewById(R.id.btnRutTienStk);
        btnXoaStk=findViewById(R.id.btnXoaStk);

//        btnRutStk.setOnClickListener(view -> addUserDialog());
        btnGuiStk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DetailActivity.this);
                alertDialog.setTitle("Gửi tiền");
//                LayoutInflater inflater = DetailActivity.this.getLayoutInflater();
                View dialogView =getLayoutInflater().inflate(R.layout.dialog_layout,null);
                alertDialog.setView(dialogView);
                EditText edTien = (EditText) dialogView.findViewById(R.id.edRutStk);


                alertDialog.setPositiveButton("OK", (dialog, which) -> {
                    String tien = edTien.getText().toString();
                    int tienGui = Integer.valueOf(tien);
                    CongStk(tienGui);
                    dialog.dismiss();
//                    Intent i = new Intent(DetailActivity.this, MainActivity.class);
//                    startActivity(i);
                    tvTien.setText(String.valueOf(ListFragment.curList.getTienTietKiem()) + " VND");
                    Toast.makeText(DetailActivity.this, "Gửi tiền thành công", Toast.LENGTH_SHORT).show();
                });
                // create and show the alert dialog
                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }
        });

        btnRutStk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DetailActivity.this);
                alertDialog.setTitle("Gửi tiền");
//                LayoutInflater inflater = DetailActivity.this.getLayoutInflater();
                View dialogView =getLayoutInflater().inflate(R.layout.dialog_layout,null);
                alertDialog.setView(dialogView);
                EditText edTien = (EditText) dialogView.findViewById(R.id.edRutStk);


                alertDialog.setPositiveButton("OK", (dialog, which) -> {
                    String tien = edTien.getText().toString();
                    int tienRut = Integer.valueOf(tien);
                    TruStk(tienRut);
                    dialog.dismiss();
//                    Intent i = new Intent(DetailActivity.this, MainActivity.class);
//                    startActivity(i);
                    tvTien.setText(String.valueOf(ListFragment.curList.getTienTietKiem()) + " VND");
                    Toast.makeText(DetailActivity.this, "Rút tiền thành công", Toast.LENGTH_SHORT).show();
                });
                // create and show the alert dialog
                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }
        });

        btnXoaStk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RutTatCaTien(ListFragment.curList.getTienTietKiem());
                QuerySoTietKiem.deleteStk(DetailActivity.this,ListFragment.curList.getId());
//                Intent i = new Intent(DetailActivity.this,MainActivity.class);

                Toast.makeText(DetailActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                ListFragment.lstStk.clear();
                ListFragment.lstStk.addAll(QuerySoTietKiem.ListSoTietKiem(DetailActivity.this, SignInActivity.loginUser));
                ListFragment.listAdapter.notifyDataSetChanged();
                finish();
            }
        });
    }

    void CongStk(int tienGui){
        int accMoney = SignInActivity.loginUser.getMoney();
        int temp = accMoney - tienGui;
        SignInActivity.loginUser.setMoney(temp);
        int a = ListFragment.curList.getTienTietKiem();
        int c = a + tienGui;
        ListFragment.curList.setTienTietKiem(c);
        DataQuery.insertMoney(DetailActivity.this,SignInActivity.loginUser);
        QuerySoTietKiem.updateMoneySTK(DetailActivity.this,ListFragment.curList.getId());
    }



    void TruStk(int tienRut)
    {
        int accMoney = SignInActivity.loginUser.getMoney();
        int temp = accMoney + tienRut;
        SignInActivity.loginUser.setMoney(temp);
        int a = ListFragment.curList.getTienTietKiem();
        int c = a - tienRut;
        ListFragment.curList.setTienTietKiem(c);
        DataQuery.insertMoney(DetailActivity.this,SignInActivity.loginUser);
        QuerySoTietKiem.updateMoneySTK(DetailActivity.this,ListFragment.curList.getId());
    }

    void RutTatCaTien(int tien)
    {
        int a = ListFragment.curList.getTienTietKiem();
        int b = SignInActivity.loginUser.getMoney();
        int c = a + b;
        SignInActivity.loginUser.setMoney(c);
        DataQuery.insertMoney(DetailActivity.this,SignInActivity.loginUser);
    }

//    void addUserDialog(){
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(DetailActivity.this);
//        alertDialog.setTitle("Rút tiền");
//        LayoutInflater inflater = DetailActivity.this.getLayoutInflater();
//        View dialogView =inflater.inflate(R.layout.dialog_layout,null);
//        alertDialog.setView(dialogView).setPositiveButton()
//        EditText edRut = findViewById(R.id.edRutStk);
//
////        alertDialog.setPositiveButton("Dông Ý",(dialog,which) -> {
////            String name = edRut.getText().toString();
////        });
//
//        alertDialog.create();
//        alertDialog.show();
//    }


}