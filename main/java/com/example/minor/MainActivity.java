package com.example.minor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_upload:
                        // do something here
                        return true;
                    case R.id.action_calculator:
                        Intent in=new Intent(MainActivity.this,calc.class);
                        startActivity(in);// do something here
                        return true;
                    case R.id.action_exercise:
                        Intent i=new Intent(MainActivity.this,uploadvi.class);
                        startActivity(i);
                        // do something here
                        return true;
                    default: return true;
                }
            }
        });
    }
}
