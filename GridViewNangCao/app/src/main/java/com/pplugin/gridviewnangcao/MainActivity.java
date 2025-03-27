package com.pplugin.gridviewnangcao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.pplugin.gridviewnangcao.model.HinhAnh;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<HinhAnh> arrayHinhAnh = new ArrayList<HinhAnh>();
    GridView gridView;
    HinhAnhAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gvHinhanh);
        arrayHinhAnh.add(new HinhAnh(R.drawable.android1, "Hinh so 1"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android2, "Hinh so 2"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android3, "Hinh so 3"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android4, "Hinh so 4"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android5, "Hinh so 5"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android6, "Hinh so 6"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android7, "Hinh so 7"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android8, "Hinh so 8"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android9, "Hinh so 9"));
        adapter = new HinhAnhAdapter(this, R.layout.xem_hinh_anh, arrayHinhAnh);
        gridView.setAdapter(adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                HinhAnh hinhAnh = arrayHinhAnh.get(i);
                Intent intent = new Intent(MainActivity.this, PictureActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("ha", hinhAnh);
                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });
    }
}