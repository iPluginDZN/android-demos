package com.pplugin.ativitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.e("AAA", "onCreate in main activity");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("AAA", "Start Main Activity");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("AAA", "On Restart Main Activity");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.e("AAA", "onResume Main Activity");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.e("AAA", "onPause Main Activity");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.e("AAA", "onStop Main Activity");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e("AAA", "onDestroy Main Activity");
    }
    public void ToActivity2(View view) {
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        startActivity(intent);
    }

    public void CloseMainActivity(View view) {
        finish();
    }
}