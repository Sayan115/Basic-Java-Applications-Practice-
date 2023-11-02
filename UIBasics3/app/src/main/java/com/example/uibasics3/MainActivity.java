package com.example.uibasics3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener{

    private CheckBox checkTerminator,checkDark,checkHarry;

    private RadioGroup rgstatus;

    private ProgressBar progress;

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == R.id.checkboxTerminator) {
            if (isChecked) {
                Toast.makeText(MainActivity.this, "YAY! You have watched Terminator", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(MainActivity.this, "You need to watch Terminator", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId==R.id.rdMarried)
            Toast.makeText(MainActivity.this, "You are married", Toast.LENGTH_SHORT).show();
        else if (checkedId==R.id.rdSingle) {
            Toast.makeText(MainActivity.this, "You are single", Toast.LENGTH_SHORT).show();
            //progress.setVisibility(View.VISIBLE);
        }
        else if(checkedId==R.id.rdRelationship) {
            Toast.makeText(MainActivity.this, "You are in a Relationship", Toast.LENGTH_SHORT).show();
            //progress.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkTerminator = findViewById(R.id.checkboxTerminator);
        checkDark = findViewById(R.id.checkboxDarkknight);
        checkHarry = findViewById(R.id.checkboxHarryPotter);

        rgstatus=findViewById(R.id.rgStatus);

        progress=findViewById(R.id.progress);
        //progress.getProgress()
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++) {
                    progress.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }
            }
        });
        thread.start();

        int id=rgstatus.getCheckedRadioButtonId();

        if(id==R.id.rdMarried)
            Toast.makeText(MainActivity.this, "You are married", Toast.LENGTH_SHORT).show();
        else if (id==R.id.rdSingle)
            Toast.makeText(MainActivity.this, "You are single", Toast.LENGTH_SHORT).show();
        else if(id==R.id.rdRelationship)
            Toast.makeText(MainActivity.this, "You are in a Relationship", Toast.LENGTH_SHORT).show();
        rgstatus.setOnCheckedChangeListener(this);

        /*rgstatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rdMarried)
                    Toast.makeText(MainActivity.this, "You are married", Toast.LENGTH_SHORT).show();
                else if (checkedId==R.id.rdSingle)
                    Toast.makeText(MainActivity.this, "You are single", Toast.LENGTH_SHORT).show();
                else if(checkedId==R.id.rdRelationship)
                    Toast.makeText(MainActivity.this, "You are in a Relationship", Toast.LENGTH_SHORT).show();
            }
        });*/

        if (checkTerminator.isChecked()) {
            Toast.makeText(this, "You have watched Terminator", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(MainActivity.this, "You need to watch Terminator", Toast.LENGTH_SHORT).show();

        checkTerminator.setOnCheckedChangeListener(this);
        checkHarry.setOnCheckedChangeListener(this);
        checkDark.setOnCheckedChangeListener(this);
        /*checkTerminator.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "YAY! You have watched Terminator", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(MainActivity.this, "You need to watch Terminator", Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}