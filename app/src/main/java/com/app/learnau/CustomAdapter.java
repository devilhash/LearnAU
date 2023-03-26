package com.app.learnau;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> implements Filterable {


    ArrayList<Subjects> names;
    ArrayList<Subjects> backUp;

    Context context;
    public CustomAdapter(Context context, ArrayList<Subjects> names){
        this.names = names;
        this.context = context;

        backUp = new ArrayList<>(names);

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2,parent,false);
        return new ViewHolder(view);

    }
    public void onBindViewHolder(@NonNull  ViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        ViewHolder myHolder = (ViewHolder) holder;
//        myHolder.name.setText((CharSequence) names.get(position));
        final Subjects temp = names.get(position);
        holder.name.setText(names.get(position).getName());
        holder.year.setText(names.get(position).getYear());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (temp.getName().toString().toLowerCase()){
                    case "artificial intelligence" :
                        context.startActivity(new Intent(context, AIActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        break;
                    case "cryptography and network security" :
                        context.startActivity(new Intent(context, CnsActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        break;
                    case "cloud computing" :
                        context.startActivity(new Intent(context, CloudComputing.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        break;
                    case "compiler design" :
                        context.startActivity(new Intent(context, CompilerDesign.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        break;
                    case "data warehousing and data mining":
                        context.startActivity(new Intent(context, Dwdm.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        break;
                    case "data communication and computer networking" :
                        context.startActivity(new Intent(context, Dccnp.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        break;
                    case "enterpreneurship" :
                        context.startActivity(new Intent(context, Enterprenuership.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        break;
                    case  "global positioning system":
                        context.startActivity(new Intent(context, Gps.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        break;
                    case "internet of things" :
                        context.startActivity(new Intent(context, IoT.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        break;
                    case "machine learning" :
                        context.startActivity(new Intent(context, ML.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        break;
                    case "object oriented software engineering" :
                        context.startActivity(new Intent(context, OOSE.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        break;
                    case "python":
                        context.startActivity(new Intent(context, Python.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        break;
                    case "r-programming":
                        context.startActivity(new Intent(context, RProgram.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        break;
                    case "web technologies":
                        context.startActivity(new Intent(context, WT.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        break;
                    case "c++":
                        context.startActivity(new Intent(context, Cplusplus.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        break;
                    case "computational biology":
                        context.startActivity(new Intent(context, CB.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        break;
                    default:
                        context.startActivity(new Intent(context, BodyActivity.class));
                        break;

                }



            }
        });
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyWord) {
            ArrayList<Subjects> filterdata = new ArrayList<>();
            if(keyWord.toString().isEmpty()){
                filterdata.addAll(backUp);
            }else{
                for(Subjects sub : backUp){
                    if(sub.getName().toString().toLowerCase().contains(keyWord.toString().toLowerCase())){
                        filterdata.add(sub);
                    }
                }
            }
             FilterResults results = new FilterResults();
            results.values = filterdata;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            names.clear();
            names.addAll((ArrayList<Subjects>)filterResults.values);
            notifyDataSetChanged();

        }
    };


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView year;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textviewitem1);
            year = itemView.findViewById(R.id.textviewitem2);
        }
    }
}
