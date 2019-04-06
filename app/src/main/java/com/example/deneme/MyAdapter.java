package com.example.deneme;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Ders> values;
    private Context context;
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtName;
        public TextView txtGrade;
        public View layout;
        public ViewHolder(View v){
            super(v);
            layout=v;
            txtName = (TextView) v.findViewById(R.id.TextViewName);
            txtGrade = (TextView) v.findViewById(R.id.TextViewGrade);
            context = itemView.getContext();
        }
    }
    public void add(int position,Ders item){
        values.add(position,item);
        notifyItemInserted(position);
    }

    public MyAdapter(ArrayList<Ders> myDataset){
        values = myDataset;
    }
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_recyler_view,parent,false);
        ViewHolder vh= new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder vh = (ViewHolder) viewHolder;
        vh.txtName.setText(values.get(i).isimAl());
        vh.txtGrade.setText(values.get(i).notAl());
        ((ViewHolder) viewHolder).txtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(context, DersInfo.class);
                myIntent.putExtra("i",i);
                myIntent.putExtra("dersAd",values.get(i).isimAl());
                myIntent.putExtra("dersNot",values.get(i).notAl());
                myIntent.putExtra("dersOgretmen",values.get(i).ogretmenAl());
                myIntent.putExtra("dersKredi",values.get(i).krediAl());
                context.startActivity(myIntent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return values.size();
    }
}

