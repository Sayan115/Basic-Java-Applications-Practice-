package com.example.listsview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView citiesList;
    private Spinner studentSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        citiesList=findViewById(R.id.citiesList);
        studentSpinner=findViewById(R.id.studentSpinner);

        /*ArrayList<String> students=new ArrayList<>();
        students.add("Sayan");
        students.add("Pritam");
        students.add("Sahil");
        students.add("Rahul");
        students.add("Jack");

        ArrayAdapter<String> studentsAdapter=new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                students
        );

        studentSpinner.setAdapter(studentsAdapter);
*/
        studentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, students.get(position)+" selected", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, studentSpinner.getSelectedItem().toString()+" selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayList<String> cities=new ArrayList<>();
        cities.add("Kolkata");
        cities.add("Chennai");
        cities.add("California");
        cities.add("Singapore");
        cities.add("Miami");


        ArrayAdapter<String>citiesadapter=new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                cities
        );
        citiesList.setAdapter(citiesadapter);

        citiesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, cities.get(position)+" selected.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}