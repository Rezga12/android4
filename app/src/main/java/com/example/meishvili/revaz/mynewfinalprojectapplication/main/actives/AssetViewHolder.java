package com.example.meishvili.revaz.mynewfinalprojectapplication.main.actives;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.meishvili.revaz.mynewfinalprojectapplication.R;

public class AssetViewHolder extends RecyclerView.ViewHolder {

    private TextView amountLabel;
    private TextView nameLabel;

    public AssetViewHolder(@NonNull View itemView) {


        super(itemView);
        amountLabel = itemView.findViewById(R.id.cell_text_amount);
        nameLabel = itemView.findViewById(R.id.cell_text_name);
    }

    public void setData(String name, String amount){
        amountLabel.setText(amount);
        nameLabel.setText(name);
    }
}
