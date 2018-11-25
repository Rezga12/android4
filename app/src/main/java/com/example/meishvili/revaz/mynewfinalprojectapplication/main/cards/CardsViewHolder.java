package com.example.meishvili.revaz.mynewfinalprojectapplication.main.cards;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meishvili.revaz.mynewfinalprojectapplication.R;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.cards.Card;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CardsViewHolder extends RecyclerView.ViewHolder {

    private ImageView cardImage;
    private ImageView visaDebitImage;

    private TextView type;
    private TextView name;
    private TextView number;
    private  TextView expDate;


    public CardsViewHolder(@NonNull View itemView) {
        super(itemView);

        cardImage = itemView.findViewById(R.id.card_image);
        visaDebitImage = itemView.findViewById(R.id.visa_debit);

        type = itemView.findViewById(R.id.card_type);
        name = itemView.findViewById(R.id.card_name);
        number = itemView.findViewById(R.id.card_number);
        expDate = itemView.findViewById(R.id.card_date);
    }

    public void setData(Card card){

        if(card.getCardName() != null && card.getCardName().equals("SOLO Card")){
            cardImage.setImageResource(R.drawable.account_background_solo);
        }else if(card.getCardClass().equals("VISA")){
            cardImage.setImageResource(R.drawable.account_background_visa_gold);
            visaDebitImage.setImageResource(R.drawable.card_icon_visa_border_single);
        }else{
            cardImage.setImageResource(R.drawable.account_background_amex_green);
            visaDebitImage.setImageResource(R.drawable.card_icon_amex_single);
        }

        type.setText(card.getCardType());
        name.setText(card.getCardHolder());
        String a = "XXXX XXXX " + card.getLastFour();
        Log.i("Assert",a);

        number.setText(a);

        Date transDate = new Date(card.getExpDate());
        SimpleDateFormat dtl = new SimpleDateFormat("mm/yy");
        expDate.setText(dtl.format(transDate));



    }


}
