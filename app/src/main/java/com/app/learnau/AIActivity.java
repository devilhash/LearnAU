package com.app.learnau;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.app.learnau.CSE.Fragments.AiSyllabus;
import com.app.learnau.CSE.Fragments.ImpTopics;

public class AIActivity extends AppCompatActivity {
    private Button syllabus;
    private Button material;
    private Button topics;
    private LinearLayout fragment;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aiactivity);
        syllabus = findViewById(R.id.ai_syllabus);
        material = findViewById(R.id.ai_material);
        topics = findViewById(R.id.ai_important_topics);
        fragment=findViewById(R.id.fragment_view);



        Intent intent = getIntent();
        String subjectName =  intent.getStringExtra("Subject");


        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSupportFragmentManager().beginTransaction().add(R.id.fragment_view,new AiSyllabus()).commit();
                 syllabus.setVisibility(View.INVISIBLE);
                 material.setVisibility(View.INVISIBLE);
                 topics.setVisibility(View.INVISIBLE);
                 fragment.setVisibility(View.VISIBLE);

            }
        });
        material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AIActivity.this, Materials.class);
                intent.putExtra("subject",subjectName);
                startActivity(intent);

            }
        });
        topics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSupportFragmentManager().beginTransaction().add(R.id.fragment_view,new ImpTopics( )).commit();
                syllabus.setVisibility(View.INVISIBLE);
                material.setVisibility(View.INVISIBLE);
                topics.setVisibility(View.INVISIBLE);
                fragment.setVisibility(View.VISIBLE);

            }
        });
    }
}