package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewPager2Item extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private static final String ARG_COUNT = "param1";
    private Integer counter;
    private static int y = 0;
    private RecyclerView.Adapter itemAdapter;

    private ArrayList<FoodList> arrayList;

    public static ViewPager2Item newInstance(Integer counter) {
        ViewPager2Item fragment = new ViewPager2Item();

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview_list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        arrayList = new ArrayList<>();
        FoodList foodList = new FoodList();
        foodList.setIv_Shop_Profile("https://firebasestorage.googleapis.com/v0/b/searchfood-4ff51.appspot.com/o/%EA%B0%80%EA%B2%8C%20%EC%82%AC%EC%A7%84%2F1%2F1.png?alt=media&token=dcec189a-77d9-4fd4-ae0c-0b7423650a93");
        foodList.setTv_Shop_Food("중식");
        foodList.setTv_Shop_Name("반점");
        foodList.setTv_Shop_Time("10:00");
        arrayList.add(foodList);
        itemAdapter = new FoodListAdapter(arrayList,getActivity());


        recyclerView.setAdapter(itemAdapter);
        itemAdapter.notifyDataSetChanged();
    }
}
