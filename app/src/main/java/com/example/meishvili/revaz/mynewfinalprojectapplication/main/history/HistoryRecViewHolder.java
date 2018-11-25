package com.example.meishvili.revaz.mynewfinalprojectapplication.main.history;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.meishvili.revaz.mynewfinalprojectapplication.R;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.transactions.MyOperation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoryRecViewHolder extends RecyclerView.ViewHolder {

    private TextView date;
    private TextView company;
    private TextView type;
    private  TextView amount;

    public HistoryRecViewHolder(@NonNull View itemView) {
        super(itemView);

        date = itemView.findViewById(R.id.history_cell_date);
        company = itemView.findViewById(R.id.history_company);
        type = itemView.findViewById(R.id.pay_or_income);
        amount = itemView.findViewById(R.id.history_cell_amount);
    }

    public void setData(MyOperation operation){

        Date transDate = new Date(operation.getPostDate());
        SimpleDateFormat dtl = new SimpleDateFormat("dd-MMM-yyyy");
        date.setText(dtl.format(transDate));

        String merchantName = operation.getMerchantName();
        merchantName = merchantName == null ? "UNKNOWN":merchantName;
        company.setText(merchantName);
        type.setText(operation.getEntryGroupName());
        amount.setText(operation.getAmount() + " " + operation.getCcy());

    }
}
