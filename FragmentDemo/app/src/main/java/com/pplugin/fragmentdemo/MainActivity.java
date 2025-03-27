package com.pplugin.fragmentdemo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements FragmentB.Counter {
    FragmentA fragmentA;
    FragmentB fragmentB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        fragmentA = new FragmentA();
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.add(R.id.main ,fragmentA);
//        fragmentB = new FragmentB();
//        transaction.add(R.id.main, fragmentB);
//        transaction.commit();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
//    public void incrementValue(int count) {
//        FragmentB fragmentB;
//        fragmentB = (FragmentB)
//                getSupportFragmentManager()
//                        .findFragmentById(R.id.fragmentContainerViewB);
//        if(fragmentB != null){
//            fragmentB.setTheCount(count);
//        }
//    }

    //Dung Interface
    @Override
    public void incrementValue(int count){
                FragmentB fragmentB;
        fragmentB = (FragmentB)
                getSupportFragmentManager()
                        .findFragmentById(R.id.fragmentContainerViewB);
        if(fragmentB != null){
            fragmentB.setTheCount(count);
        }
    }
}