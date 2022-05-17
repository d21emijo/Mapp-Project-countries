package com.example.mapp_project_countries;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CountriesViewHolder> {


    private List<Countries> items = new ArrayList<>(); //hämta lista från mainactivity+fyller med samma items

    public void setItems(List<Countries> items) {
        this.items = items;
    }

    public RecyclerViewAdapter() {

    }

    @Override
    @NonNull
    public MountainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MountainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.countries,parent,false));
    }

    @Override
    public void onBindViewHolder(MountainViewHolder holder, int position) {
        Countries countries = items.get(position);//hämta index position

        holder.title.setText(countries.getName()); //skriva ut i title name för index
        //för att skapa mer gör ny textview och använd settext som ovan.

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MountainViewHolder extends RecyclerView.ViewHolder  {
        TextView title;

        MountainViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
        }

    }

    public interface OnClickListener {
        void onClick(RecyclerViewItem item);
    }
}