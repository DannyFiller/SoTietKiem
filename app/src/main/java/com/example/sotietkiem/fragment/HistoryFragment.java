package com.example.sotietkiem.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sotietkiem.R;
import com.example.sotietkiem.UserAdapter;

import java.util.ArrayList;

import data.DataQuery;
import data.User;

public class HistoryFragment extends Fragment implements UserAdapter.UserCallback{

    Context context ;
    RecyclerView rvListC;
    ArrayList<User> lstUser;
    UserAdapter userAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_history, container, false);
        context = container.getContext();
        rvListC = v.findViewById(R.id.rcList);
        userAdapter= new UserAdapter(lstUser);
        userAdapter.setUserCallback(this);
////
        lstUser = DataQuery.getAll(getContext());
//
//
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        rvListC.setAdapter(userAdapter);
        rvListC.setLayoutManager(linearLayoutManager);

        return v;
        }




    @Override
    public void onItemClick(String id) {

    }
}