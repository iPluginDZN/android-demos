package com.pplugin.gridviewnangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.pplugin.gridviewnangcao.model.HinhAnh;

import java.util.List;

public class HinhAnhAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<HinhAnh> hinhAnhList;

    public HinhAnhAdapter(Context context, int layout, List<HinhAnh> hinhAnhList) {
        this.context = context;
        this.layout = layout;
        this.hinhAnhList = hinhAnhList;
    }

    public List<HinhAnh> getHinhAnhList() {
        return hinhAnhList;
    }

    public void setHinhAnhList(List<HinhAnh> hinhAnhList) {
        this.hinhAnhList = hinhAnhList;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return hinhAnhList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        ImageView imageView = view.findViewById(R.id.imgHinhAnh);

        HinhAnh hinhAnh = hinhAnhList.get(position);
        imageView.setImageResource(hinhAnh.getHinh());
        return view;
    }
}
