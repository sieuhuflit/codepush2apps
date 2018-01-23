package com.example.codepush2apps.codepush2apps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtLaunchActivity1;
    private Button mBtLaunchActivity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtLaunchActivity1 = findViewById(R.id.button1);
        mBtLaunchActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMyRNAppActivity1();
            }
        });

        mBtLaunchActivity2 = findViewById(R.id.button2);
        mBtLaunchActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMyRNAppActivity2();
            }
        });
    }

    private void launchMyRNAppActivity1() {

        Intent intent = new Intent(this, MyRNApp1.class);
        startActivity(intent);
    }

    private void launchMyRNAppActivity2() {

        Intent intent = new Intent(this, MyRNApp2.class);
        startActivity(intent);
    }

}
