package com.pplugin.navbardemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.pplugin.navbardemo.adapter.HinhAnhAdapter;
import com.pplugin.navbardemo.model.HinhAnh;

import java.util.ArrayList;

public class FirstFragment extends Fragment {
    ArrayList<HinhAnh> arrayHinhAnh = new ArrayList<HinhAnh>();
    GridView gridView;
    HinhAnhAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.first_fragment, container, false);
        gridView = v.findViewById(R.id.gvHinhanh);
        arrayHinhAnh.add(new HinhAnh(R.drawable.android1, "Hinh so 1"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android2, "Hinh so 2"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android3, "Hinh so 3"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android4, "Hinh so 4"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android5, "Hinh so 5"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android6, "Hinh so 6"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android7, "Hinh so 7"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android8, "Hinh so 8"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android9, "Hinh so 9"));
        Context class_context = v.getContext();
        adapter = new HinhAnhAdapter(class_context, R.layout.image_view, arrayHinhAnh);
        gridView.setAdapter(adapter);
        ViewCompat.setOnApplyWindowInsetsListener(v.findViewById(R.id.main), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                HinhAnh hinhAnh = arrayHinhAnh.get(i);
                Intent intent = new Intent(v.getContext(), PictureActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("ha", hinhAnh);
                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });
        return v;
    }

}
