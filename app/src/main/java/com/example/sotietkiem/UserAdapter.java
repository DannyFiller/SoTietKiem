package com.example.sotietkiem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import data.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    ArrayList<User> lstUser;

    Context context;
    UserCallback userCallback;

    public UserAdapter(ArrayList<User> lstUser) {
        this.lstUser = lstUser;
    }
    public void setUserCallback(UserCallback userCallback) {
        this.userCallback = userCallback;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater= LayoutInflater.from(context);
        View userView = inflater.inflate(R.layout.itemlayout, parent,false);
        UserViewHolder viewHolder= new UserViewHolder(userView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User item= lstUser.get(position);
        holder.tvName.setText(item.getUserName());


//        holder.itemView.setOnClickListener(view -> userCallback.onItemClick(item.getId()));
    }

    @Override
    public int getItemCount() {

        if (lstUser!=null)
            return lstUser.size();
        else
            return 0;
    }


    class UserViewHolder extends RecyclerView.ViewHolder{

        ImageView imAvatar;
        TextView tvName;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
        }
    }

    public interface UserCallback{
        void onItemClick(String id);
    }
}
