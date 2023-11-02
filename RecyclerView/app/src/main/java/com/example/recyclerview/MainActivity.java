package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycleContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleContacts=findViewById(R.id.recycleContacts);
        ArrayList<Contacts> contacts=new ArrayList<>();
        contacts.add(new Contacts("Steve Rogers","steverog@gmail.com","https://w0.peakpx.com/wallpaper/775/1010/HD-wallpaper-steve-rogers-age-of-ultron-avengers-steve-rogers-thumbnail.jpg"));
        contacts.add(new Contacts("Tobey Maguire","tobey1@rediffmail.com","https://www.the-sun.com/wp-content/uploads/sites/6/2021/03/NINTCHDBPICT000341342005.jpg"));
        contacts.add(new Contacts("Paulo Dybala","dybala10@gmail.com","https://i.pinimg.com/550x/71/aa/3a/71aa3a0fd4fb3c48754c8b63134b847c.jpg"));
        contacts.add(new Contacts("Christian Bale","bale@gmail.com","https://www.kimdirwiki.com/wp-content/uploads/2013/08/5283-christian-bale.jpg"));
        contacts.add(new Contacts("Keanu Reeves","reeves@gmail.com","https://people.com/thmb/nzmLZ6kNr29U_nnlHR_xvDY2Lpo=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc():focal(665x0:667x2)/keanu-reeves-2000-6c1a85f168344ea18783e126b5e4a331.jpg"));

        ContactsRecViewAdapter adapter=new ContactsRecViewAdapter(this);
        adapter.setContacts(contacts);
        recycleContacts.setAdapter(adapter);
/*
        recycleContacts.setLayoutManager(new LinearLayoutManager(this));
*/
        recycleContacts.setLayoutManager(new GridLayoutManager(this,2));
    }
}