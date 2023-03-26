package com.app.learnau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

public class EEE extends AppCompatActivity {
    private RecyclerView rec;
    ArrayList<Subjects> eee;
    CustomAdapter adapter;
    SearchView search;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eee);
        rec = findViewById(R.id.receee);
        search = findViewById(R.id.searcheee);



        eee = new ArrayList<>();

        Subjects s1 = new Subjects();
        s1.setName("Construction Management");
        s1.setYear("4.1");
        eee.add(s1);

        Subjects s6 = new Subjects();
        s6.setName("Environmental Impact");
        s6.setYear("4.1");
        eee.add(s6);

        Subjects s2 = new Subjects();
        s2.setName("Fluid Mechanics - III ");
        s2.setYear("4.1");
        eee.add(s2);

        Subjects s3 = new Subjects();
        s3.setName("Geotechnical Engineering - II");
        s3.setYear("4.1");
        eee.add(s3);

        Subjects s4 = new Subjects();
        s4.setName("Prestressed Concrete");
        s4.setYear("4.1");
        eee.add(s4);

        Subjects s5 = new Subjects();
        s5.setName("Water resources Engineering - II");
        s5.setYear("4.1");
        eee.add(s5);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rec.setLayoutManager(linearLayoutManager);
        adapter = new CustomAdapter(EEE.this,eee);
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