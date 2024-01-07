package com.example.myapplication;
/**
 * @author Kyle Perry
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showSpecialty(View view){
        Intent intent = new Intent(this, SpecialtyActivity.class);
        startActivity(intent);
    }

    public void showBuild(View view){
        Intent intent = new Intent(this, BuildActivity.class);
        startActivity(intent);
    }
    public void showCurrent(View view){
        Intent intent = new Intent(this, CurrentActivity.class);
        startActivity(intent);
    }
    public void showStore(View view){
        Intent intent = new Intent(this, StoreActivity.class);
        startActivity(intent);
    }
}