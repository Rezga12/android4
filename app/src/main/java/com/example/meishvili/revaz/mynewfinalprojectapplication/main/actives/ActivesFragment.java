package com.example.meishvili.revaz.mynewfinalprojectapplication.main.actives;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meishvili.revaz.mynewfinalprojectapplication.R;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.assetsandliabilities.Asset;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.assetsandliabilities.AssetsAndLiabilities;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.assetsandliabilities.AvailableAmount;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.assetsandliabilities.Liability;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.assetsandliabilities.Point;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.login.Login;
import com.example.meishvili.revaz.mynewfinalprojectapplication.network.Api;
import com.example.meishvili.revaz.mynewfinalprojectapplication.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ActivesFragment extends Fragment {

    public static ActivesFragment newInstance(String sessionId) {

        Bundle args = new Bundle();
        args.putString("id",sessionId);

        ActivesFragment fragment = new ActivesFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_actives,container,false);

        recyclerView = view.findViewById(R.id.acives_rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Log.i("Assert",list.size() + "");
        adapter = new ActivesAdapter();
        recyclerView.setAdapter(adapter);
        getAssetsAndLiabilities();
        return view;
    }

    private List<Object> list;
    private ActivesAdapter adapter;


    private void getAssetsAndLiabilities(){

        String sessionId = getArguments().getString("id");
        list = new ArrayList<>();
        final Retrofit retrofit = RetrofitInstance.getRetrofitInstance(sessionId);

        Api api = retrofit.create(Api.class);


        api.getAssetsAndLiabilities().enqueue(new Callback<AssetsAndLiabilities>() {
            @Override
            public void onResponse(Call<AssetsAndLiabilities> call, Response<AssetsAndLiabilities> response) {



                list.add(getResources().getString(R.string.asset_name_points));

                for(Point p : response.body().getPoints()){
                    //points.add();
                    list.add(new Pair<> (p.getProductName(),p.getAmount().doubleValue()));
                }

                list.add(getResources().getString(R.string.asset_name_assets));
                for(Asset a : response.body().getAssets()){
                    list.add(new Pair<>(a.getProductName(),a.getAmountBase()));
                }

                list.add(getResources().getString(R.string.asset_name_liabilities));
                for(Liability a : response.body().getLiabilities()){
                    list.add(new Pair<>(a.getProductName(),a.getAmountBase()));
                }

                list.add(getResources().getString(R.string.asset_name_amounts));
                for(AvailableAmount a : response.body().getAvailableAmounts()){
                    list.add(new Pair<>(a.getProductName(),a.getAmountBase()));
                }


                adapter.setData(list);
            }

            @Override
            public void onFailure(Call<AssetsAndLiabilities> call, Throwable t) {
                Log.i("Assert",t.getMessage());
            }
        });


    }
}
