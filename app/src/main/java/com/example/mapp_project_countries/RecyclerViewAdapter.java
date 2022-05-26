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
    public CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountriesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.countries,parent,false));
    }

    @Override
    public void onBindViewHolder(CountriesViewHolder holder, int position) {
        Countries countries = items.get(position);//hämta index position

        holder.country.setText("name: "+countries.getName()); //skriva ut i title name för index
        holder.whatdo.setText("Continent: " +countries.getLocation());
        holder.population.setText(String.valueOf("population: " + countries.getSize())+ " thousand");

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CountriesViewHolder extends RecyclerView.ViewHolder  {
        TextView country;
        TextView whatdo;
        TextView population;

        CountriesViewHolder(View itemView) {
            super(itemView);

            country = itemView.findViewById(R.id.country);
            population = itemView.findViewById(R.id.population);
            whatdo = itemView.findViewById(R.id.whatdo);
        }

    }

    public interface OnClickListener {
        void onClick(RecyclerViewItem item);
    }
}