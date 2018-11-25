package com.example.meishvili.revaz.mynewfinalprojectapplication.main.actives;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.meishvili.revaz.mynewfinalprojectapplication.R;

public class HeaderViewHolder extends RecyclerView.ViewHolder {

    private TextView header;

    public HeaderViewHolder(@NonNull View itemView) {
        super(itemView);
        header = itemView.findViewById(R.id.header_text);
    }

    public void setTitle(String title){

        header.setText(title);
    }
}
