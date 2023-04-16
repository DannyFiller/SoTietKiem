package com.example.sotietkiem.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sotietkiem.R;
import com.example.sotietkiem.SignInActivity;
import com.example.sotietkiem.UserAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;

import InOut.MoneyInActivity;

import InOut.NapActivity;
import InOut.OutMoneyActivity;
import data.User;


public class HomeFragment extends Fragment implements UserAdapter.UserCallback{

    private final Gson gson = new Gson();
    EditText edSoTien;
    Button btnXacNhan,btnDangNhap;
    Context context;
    RecyclerView rvListC;
    ArrayList<User> lstUser;
    UserAdapter userAdapter;

    TextView tvKetQua,tvTen,btnGuiTK,btnRutTK,btnNap;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        User user= SignInActivity.loginUser;
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        rvListC.setAdapter(userAdapter);
//        rvListC.setLayoutManager(linearLayoutManager);

//        edSoTien = v.findViewById(R.id.edSotien);
//        btnXacNhan = v.findViewById(R.id.btnXacNhan);
        tvKetQua = v.findViewById(R.id.tvKetQua);
        tvTen = v.findViewById(R.id.tvTen );
        btnGuiTK=v.findViewById(R.id.tvbtnGuiTK);
//        btnRutTK= v.findViewById(R.id.tvbtnRut);
        btnNap = v.findViewById(R.id.tvbtnNap);

        String tienHienCo = String.valueOf(SignInActivity.loginUser.getMoney());
        tvTen.setText(SignInActivity.loginUser.getUserName());
        tvKetQua.setText(tienHienCo);


//        Bundle goi = getActivity().getIntent().getExtras();
//
//        String usingUser = goi.getString("username");
//        User loginUser = new User(usingUser);
//        User user1 = DataQuery.GetMoney(getContext(),loginUser);
//        String money = String.valueOf(user1.getMoney());
//        tvKetQua.setText(money);


        btnGuiTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), MoneyInActivity.class);
                startActivity(i);
            }
        });

//        btnRutTK.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getActivity(), OutMoneyActivity.class);
//                startActivity(i);
//            }
//        });

        btnNap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), NapActivity.class);
                startActivity(i);
            }
        });




        return v;
    }




//    void LoadData()
//    {
//        lstUser = new ArrayList<>();
//        lstUser.add(new User("khoi2134","1234567","123@gmail.com","1234567"));
//        lstUser.add(new User("khoi2134","1234567","123@gmail.com","1234567"));
//        lstUser.add(new User("khoi2134","1234567","123@gmail.com","1234567"));
//    }

    @Override
    public void onItemClick(String id) {

    }
//    void ShowData(int rs){
//        tvKetQua.setText(String.valueOf(rs));
//    }

//    void Cong(){
//        String txtSoTienCong = edSoTien.getText().toString();
//        String txtSoTienHienTai = tvKetQua.getText().toString();
//        if (txtSoTienCong.isEmpty()){
//            tvKetQua.setText("Số tiền hiện có");
//            return;
//        }
//        int a = Integer.valueOf(txtSoTienHienTai);
//        int b = Integer.valueOf(txtSoTienCong);
//
//        int c = a+b;
//
//        ShowData(c);
//    }
}