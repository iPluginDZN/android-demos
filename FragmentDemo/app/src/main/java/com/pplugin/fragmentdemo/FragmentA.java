package com.pplugin.fragmentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {
    Button button;
    int count = 0;
    FragmentB.Counter counter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_a, container, false);
        button = v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                counter = (FragmentB.Counter) getActivity();
                counter.incrementValue(count);
//                MainActivity mainActivity = (MainActivity) getActivity();
//                mainActivity.incrementValue(count);
            }
        });
        return v;
    }
}
