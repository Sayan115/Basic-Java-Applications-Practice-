package com.example.uibasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Button helloButton=findViewById(R.id.hiButton);
        helloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Hi there!!!");
            }
        });*/

    }

    public void onHelloBtnClicked(View view){
        TextView txtWelcome=findViewById(R.id.welcomeMsg);
        txtWelcome.setText("Hello there!!!");
    }
}