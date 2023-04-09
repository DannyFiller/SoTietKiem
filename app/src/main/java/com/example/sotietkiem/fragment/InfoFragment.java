package com.example.sotietkiem.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sotietkiem.MainActivity;
import com.example.sotietkiem.R;
import com.example.sotietkiem.SignInActivity;


public class InfoFragment extends Fragment {
    TextView tvTen,tvPassword;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info, container, false);

        tvTen = v.findViewById(R.id.tvUserNameInfo);
        tvPassword = v.findViewById(R.id.tvPasswordInfo);

        //lấy thông tin từ Intent SignIn

//        Bundle goi = getActivity().getIntent().getExtras();
        String ten = SignInActivity.loginUser.getUserName();
        String password = SignInActivity.loginUser.getPassword();

        tvTen.setText(ten);
        tvPassword.setText(password);

        return v;
    }
}