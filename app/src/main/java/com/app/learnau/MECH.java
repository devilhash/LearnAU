package com.app.learnau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

public class MECH extends AppCompatActivity {
    private RecyclerView rec;
    ArrayList<Subjects> mech;
    CustomAdapter adapter;
    SearchView search;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mech);
        rec = findViewById(R.id.recmech);
        search = findViewById(R.id.searchmech);

        mech = new ArrayList<>();

        Subjects s1 = new Subjects();
        s1.setName("Construction Management");
        s1.setYear("4.1");
        mech.add(s1);

        Subjects s6 = new Subjects();
        s6.setName("Environmental Impact");
        s6.setYear("4.1");
        mech.add(s6);

        Subjects s2 = new Subjects();
        s2.setName("Fluid Mechanics - III ");
        s2.setYear("4.1");
        mech.add(s2);

        Subjects s3 = new Subjects();
        s3.setName("Geotechnical Engineering - II");
        s3.setYear("4.1");
        mech.add(s3);

        Subjects s4 = new Subjects();
        s4.setName("Prestressed Concrete");
        s4.setYear("4.1");
        mech.add(s4);

        Subjects s5 = new Subjects();
        s5.setName("Water resources Engineering - II");
        s5.setYear("4.1");
        mech.add(s5);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rec.setLayoutManager(linearLayoutManager);
        adapter = new CustomAdapter(MECH.this,mech);
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