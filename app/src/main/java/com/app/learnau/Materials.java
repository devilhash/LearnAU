package com.app.learnau;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.learnau.CSE.Fragments.model;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Materials extends AppCompatActivity {
    private RecyclerView recyclervView;
    private ImageView add;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials);
        recyclervView = findViewById(R.id.recyclerMaterial);
        add = findViewById(R.id.addbutton);

        Intent intent = getIntent();
        String name = intent.getStringExtra("subject");
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        FirebaseRecyclerOptions<model> options = new FirebaseRecyclerOptions.Builder<model>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("My_Documents").child(name).child("materials") , model.class)
                .build();
        FirebaseRecyclerAdapter<model,MyViewholder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<model, MyViewholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewholder holder, int position, @NonNull model model) {
                holder.fileName.setText(model.getFilename());
                holder.fileName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(holder.fileName.getContext(), ViewPdf.class);
                        intent.putExtra("filename", model.getFilename());
                        intent.putExtra("fileurl", model.getFileurl());
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        holder.fileName.getContext().startActivity(intent);
                    }
                });

            }

            @NonNull
            @Override
            public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item3,parent,false);
                return new  MyViewholder(v);
            }
        };

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Materials.this, UploadActivity.class);
                intent.putExtra("Document","materials");
                intent.putExtra("subject",name);
                startActivity(intent);
            }
        });
        firebaseRecyclerAdapter.startListening();
        recyclervView.setAdapter(firebaseRecyclerAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclervView.setLayoutManager(layoutManager);

    }

    public static class MyViewholder extends RecyclerView.ViewHolder{
        TextView fileName;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            fileName = itemView.findViewById(R.id.textviewitem3);
        }
    }
}