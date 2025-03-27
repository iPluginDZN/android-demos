package com.pplugin.navbardemo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.pplugin.navbardemo.adapter.CityAdapter;
import com.pplugin.navbardemo.model.City;

import java.util.ArrayList;

public class SecondFragment extends Fragment {
    ListView lvCity;
    ArrayList<City> cityArrayList = new ArrayList<>();
    CityAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.second_fragment, container, false);
        lvCity = v.findViewById(R.id.lvCity);
        cityArrayList.add(new City("New York",R.drawable.newyork,"http://1.com"));
        cityArrayList.add(new City("Paris",R.drawable.paris,"http://2.com"));
        cityArrayList.add(new City("Rome",R.drawable.rome,"http://3.com"));
        Context class_context = v.getContext();
        adapter = new CityAdapter(class_context,R.layout.dong_thanh_pho,cityArrayList);
        lvCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });
        lvCity.setAdapter(adapter);
        ViewCompat.setOnApplyWindowInsetsListener(v.findViewById(R.id.main), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        return v;
    }
}
