package com.example.uichallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText txtName,txtEmail,txtPassword,txtRepassword;
    private ImageView txtImg;
    private TextView txtWarnName,txtWarnEmail,txtWarnPassword,txtWarnRepassword;
    private RadioGroup rgGender;
    private Button buttonImg, buttonRegister;
    private Spinner spinnerCountry;
    private CheckBox checkAgree;
    private ConstraintLayout parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        buttonImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Yet to see", Toast.LENGTH_SHORT).show();
            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initRegister();
            }
        });
    }

    private void initRegister()
    {
        Log.d(TAG, "initRegister: Started");
        if(validateData())
        {
            if (checkAgree.isChecked())
            {
                showSnackBar();
            }
            else {
                Toast.makeText(this, "Your need to agree to the License Agreement", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showSnackBar()
    {
        Log.d(TAG, "showSnackBar: Started");
        txtWarnName.setVisibility(View.GONE);
        txtWarnPassword.setVisibility(View.GONE);
        txtWarnEmail.setVisibility(View.GONE);
        txtWarnRepassword.setVisibility(View.GONE);

        String name=txtName.getText().toString();
        String email=txtEmail.getText().toString();
        String country=spinnerCountry.getSelectedItem().toString();
        String gender="";
        if(rgGender.getCheckedRadioButtonId()==R.id.radioMale)
            gender="Male";
        else if(rgGender.getCheckedRadioButtonId()==R.id.radioFemale)
            gender="Female";
        else gender="Other";

        String st="Name: "+name+"\nEmail: "+email+"\nCountry: "+country+"\nGender: "+gender;
        Log.d(TAG, "showSnackBar: SnackText"+st);
        Snackbar.make(parent,st,Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txtName.setText("");
                        txtEmail.setText("");
                        txtPassword.setText("");
                        txtRepassword.setText("");

                    }
                }).show();
    }
    private boolean validateData()
    {
        Log.d(TAG, "validateData: Started");
        if(txtName.getText().toString().equals(""))
        {
            txtWarnName.setVisibility(View.VISIBLE);
            txtWarnName.setText("Enter your Name");
            return false;
        }
        if(txtEmail.getText().toString().equals(""))
        {
            txtWarnEmail.setVisibility(View.VISIBLE);
            txtWarnEmail.setText("Enter your Email");
            return false;
        }
        if(txtPassword.getText().toString().equals(""))
        {
            txtWarnPassword.setVisibility(View.VISIBLE);
            txtWarnPassword.setText("Enter your password");
            return false;
        }
        if(txtRepassword.getText().toString().equals(""))
        {
            txtWarnRepassword.setVisibility(View.VISIBLE);
            txtWarnRepassword.setText("Re-enter your password");
            return false;
        }
        if(!txtPassword.getText().toString().equals(txtRepassword.getText().toString()))
        {
            txtWarnRepassword.setVisibility(View.VISIBLE);
            txtWarnRepassword.setText("Password should be the same");
            return false;
        }
        return true;
    }
    private void initViews()
    {
        Log.d(TAG, "initViews: Started");
        txtImg=findViewById(R.id.txtImg);
        buttonImg=findViewById(R.id.buttonImg);
        txtName=findViewById(R.id.txtName);
        txtEmail=findViewById(R.id.txtEmail);
        txtPassword=findViewById(R.id.txtPassword);
        txtRepassword=findViewById(R.id.txtRePassword);
        rgGender=findViewById(R.id.rgGender);
        spinnerCountry=findViewById(R.id.spinnerCountry);
        buttonRegister=findViewById(R.id.buttonRegister);
        checkAgree=findViewById(R.id.checkAgree);
        txtWarnName=findViewById(R.id.txtWarnName);
        txtWarnEmail=findViewById(R.id.txtWarnEmail);
        txtWarnPassword=findViewById(R.id.txtWarnPassword);
        txtWarnRepassword=findViewById(R.id.txtWarnRepassword);
        parent=findViewById(R.id.parent);
    }
}