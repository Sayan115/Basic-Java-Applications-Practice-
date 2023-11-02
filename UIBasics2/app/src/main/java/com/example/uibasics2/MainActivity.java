package com.example.uibasics2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTxtName;
    TextView txtHi;
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnHello)
        {
            //Toast.makeText(this, "Hello there!!", Toast.LENGTH_SHORT).show();
            txtHi.setText("Hello "+editTxtName.getText()+";)".toString());
        }
        else if(v.getId()==R.id.editTxtName)
            Toast.makeText(this, "Write your name", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHello=findViewById(R.id.btnHello);
        btnHello.setOnClickListener(this);

        btnHello.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "Long Press", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        editTxtName=findViewById(R.id.editTxtName);
        editTxtName.setOnClickListener(this);
        txtHi=findViewById(R.id.textHi);
    }
}