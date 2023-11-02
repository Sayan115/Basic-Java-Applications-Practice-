package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.sax.TextElementListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void onClicking(View view){
        TextView txtfName=findViewById(R.id.fName);
        EditText editTxtName=findViewById(R.id.editFName);
        txtfName.setText(editTxtName.getText().toString());

        TextView txtlName=findViewById(R.id.lName);
        EditText editlName=findViewById(R.id.editLName);
        txtlName.setText(editlName.getText().toString());

        TextView txtEmail=findViewById(R.id.email);
        EditText editEmail=findViewById(R.id.editEmail);
        txtEmail.setText(editEmail.getText().toString());
    }
}