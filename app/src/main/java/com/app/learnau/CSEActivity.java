package com.app.learnau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class CSEActivity extends AppCompatActivity {
   private RecyclerView recyclerview;
    CustomAdapter customAdapter;
    SearchView search;
   ArrayList<Subjects> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cseactivity);
        recyclerview = findViewById(R.id.recyclerview);
        search = findViewById(R.id.searchView);

        names = new ArrayList<>();
        Subjects s1 = new Subjects();
        s1.setName("Artificial Intelligence");
        s1.setYear("3.1");
        names.add(s1);

        Subjects s2 = new Subjects();
        s2.setName("Cryptography and Network Security");
        s2.setYear("3.1");
        names.add(s2);

        Subjects s3 = new Subjects();
        s3.setName("Cloud Computing");
        s3.setYear("3.1");
        names.add(s3);

        Subjects s4 = new Subjects();
        s4.setName("Compiler Design");
        s4.setYear("3.1");
        names.add(s4);

        Subjects s5 = new Subjects();
        s5.setName("Data Warehousing and Data Mining");
        s5.setYear("3.1");
        names.add(s5);

        Subjects s6 = new Subjects();
        s6.setName("Data Communication and Computer Networking");
        s6.setYear("3.1");
        names.add(s6);

        Subjects s7 = new Subjects();
        s7.setName("Enterpreneurship");
        s7.setYear("3.1");
        names.add(s7);

        Subjects s8 = new Subjects();
        s8.setName("Global Positioning System");
        s8.setYear("3.1");
        names.add(s8);

        Subjects s9 = new Subjects();
        s9.setName("Internet Of Things");
        s9.setYear("3.1");
        names.add(s9);

        Subjects s10 = new Subjects();
        s10.setName("Machine Learning");
        s1.setYear("3.1");
        names.add(s10);

        Subjects s11 = new Subjects();
        s11.setName("Object Oriented Software Engineering");
        s11.setYear("3.1");
        names.add(s11);

        Subjects s12 = new Subjects();
        s12.setName("Python");
        s12.setYear("3.1");
        names.add(s12);

        Subjects s13 = new Subjects();
        s13.setName("R-Programming");
        s13.setYear("3.1");
        names.add(s13);

        Subjects s14 = new Subjects();
        s14.setName("Web Technologies");
        s14.setYear("3.1");
        names.add(s14);

        Subjects s15 = new Subjects();
        s15.setName("c++");
        s15.setYear("3.1");
        names.add(s15);

        Subjects s16 = new Subjects();
        s16.setName("Computational Biology");
        s16.setYear("3.1");
        names.add(s16);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(linearLayoutManager);
        customAdapter = new CustomAdapter(CSEActivity.this,names );
        recyclerview.setAdapter(customAdapter);

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                customAdapter.getFilter().filter(newText);
                return false;
            }
        });




    }



}