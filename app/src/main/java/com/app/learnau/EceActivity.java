package com.app.learnau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class EceActivity extends AppCompatActivity {
    ArrayList<Subjects> names;
    private RecyclerView rec;
    CustomAdapter adapter;
    SearchView search;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece);
        rec = findViewById(R.id.recece);
        search = findViewById(R.id.searchece);


        names = new ArrayList<>();

        Subjects s1 = new Subjects();
        s1.setName("Computer Networks");
        s1.setYear("3.1");
        names.add(s1);

        Subjects s2 = new Subjects();
        s2.setName("Digital Communications");
        s2.setYear("3.1");
        names.add(s2);

        Subjects s3 = new Subjects();
        s3.setName("Information Theory and Coding");
        s3.setYear("3.1");
        names.add(s3);

        Subjects s4 = new Subjects();
        s4.setName("Linear IC Applications");
        s4.setYear("3.1");
        names.add(s4);

        Subjects s5 = new Subjects();
        s5.setName("Microwave Engineering");
        s5.setYear("3.1");
        names.add(s5);

        Subjects s10 = new Subjects();
        s10.setName("Computer Networks");
        s10.setYear("3.1");
        names.add(s10);

        Subjects s6 = new Subjects();
        s6.setName("Principles of Economic Management");
        s6.setYear("3.1");
        names.add(s6);

        Subjects s7 = new Subjects();
        s7.setName("Pulse Digital Circuit");
        s7.setYear("3.1");
        names.add(s7);

        Subjects s8 = new Subjects();
        s8.setName("Radar Engineering");
        s8.setYear("3.1");
        names.add(s8);

        Subjects s9 = new Subjects();
        s9.setName("Telecommunications Switching Systems");
        s9.setYear("3.1");
        names.add(s9);

        Subjects s11 = new Subjects();
        s11.setName("Television and Satellite");
        s11.setYear("3.1");
        names.add(s11);

        Subjects s12 = new Subjects();
        s12.setName("Very Large Scale Integration");
        s12.setYear("3.1");
        names.add(s12);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rec.setLayoutManager(linearLayoutManager);
        adapter = new CustomAdapter(EceActivity.this,names);
        rec.setAdapter(adapter);

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });


    }
}