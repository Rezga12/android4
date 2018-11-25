package com.example.meishvili.revaz.mynewfinalprojectapplication.main.profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.meishvili.revaz.mynewfinalprojectapplication.R;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.clientinfo.ClientInfo;
import com.example.meishvili.revaz.mynewfinalprojectapplication.network.Api;
import com.example.meishvili.revaz.mynewfinalprojectapplication.network.RetrofitInstance;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProfileFragment extends Fragment {

    public static ProfileFragment newInstance(String sessionId) {

        Bundle args = new Bundle();
        args.putString("id",sessionId);

        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private TextView nameLabel;
    private TextView lastnameLabel;
    private TextView sexLabel;
    private TextView dateLabel;
    private TextView categoryLabel;
    private TextView phoneLabel;
    private TextView addressLabel;
    private TextView mailLabel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile,container,false);

        nameLabel = view.findViewById(R.id.answer_name);
        lastnameLabel = view.findViewById(R.id.answer_lastname);
        sexLabel = view.findViewById(R.id.answer_sex);
        dateLabel = view.findViewById(R.id.answer_date);
        categoryLabel = view.findViewById(R.id.answer_category);
        phoneLabel = view.findViewById(R.id.answer_phone);
        addressLabel = view.findViewById(R.id.answer_address);
        mailLabel = view.findViewById(R.id.answer_mail);

        getClientInfo();

        return view;
    }

    private void getClientInfo(){

        String sessionId = getArguments().getString("id");


        Retrofit retrofit = RetrofitInstance.getRetrofitInstance(sessionId);

        Api api = retrofit.create(Api.class);
        api.getClientInfo().enqueue(new Callback<ClientInfo>() {
            @Override
            public void onResponse(Call<ClientInfo> call, Response<ClientInfo> response) {
                if(response.isSuccessful()){
                    ClientInfo info = response.body();
                    nameLabel.setText(info.getClient().getFirstName());
                    lastnameLabel.setText(info.getClient().getLastName());
                    sexLabel.setText(info.getClient().getSex());


                    Date birthDate = new Date(Long.parseLong(info.getClient().getBirthDate()));
                    SimpleDateFormat dtl = new SimpleDateFormat("dd.mm.yyyy");
                    dateLabel.setText(dtl.format(birthDate));


                    categoryLabel.setText(info.getClient().getClientCategory());

                    phoneLabel.setText(info.getClientPhones().get(0).getMobile());
                    addressLabel.setText(info.getClientAddresses().get(0).getStreet() + " "
                                            + info.getClientAddresses().get(0).getBuilding() + " "
                                            + info.getClientAddresses().get(0).getAppartment());
                    mailLabel.setText( info.getClientMails().get(0).getMail());
                }
            }

            @Override
            public void onFailure(Call<ClientInfo> call, Throwable t) {
                Log.i("Assert",t.getMessage());
            }
        });



    }
}
