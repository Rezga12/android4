package com.example.meishvili.revaz.mynewfinalprojectapplication.main.cards;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meishvili.revaz.mynewfinalprojectapplication.R;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.cards.Card;
import com.example.meishvili.revaz.mynewfinalprojectapplication.network.Api;
import com.example.meishvili.revaz.mynewfinalprojectapplication.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CardFragment extends Fragment {

    public static CardFragment newInstance(String sessionId) {

        Bundle args = new Bundle();
        args.putString("id",sessionId);
        CardFragment fragment = new CardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private RecyclerView recyclerView;
    private CardsViewAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //View view = inflater.inflate(R.layout.fragment_photo,container,false);
        View view = inflater.inflate(R.layout.fragment_cards,container,false);

        recyclerView = view.findViewById(R.id.card_rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new CardsViewAdapter();
        recyclerView.setAdapter(adapter);

        getCards();

        return view;
    }

    void getCards(){

        Retrofit retrofit = RetrofitInstance.getRetrofitInstance(getArguments().getString("id"));
        Api api = retrofit.create(Api.class);

        api.getCards().enqueue(new Callback<List<Card>>() {
            @Override
            public void onResponse(Call<List<Card>> call, Response<List<Card>> response) {
                adapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<List<Card>> call, Throwable t) {

            }
        });

    }

}
