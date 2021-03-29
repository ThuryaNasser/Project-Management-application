package com.example.manaagementapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class Adapter extends RecyclerView.Adapter<Adapter.ExampleViewHolder> {
    public ArrayList<card> mExampleList;
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView ProjectName;
        public TextView Description;
        public TextView Goal;
        public TextView StartDate;
        public TextView EndDate;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            ProjectName = itemView.findViewById(R.id.ProjectNameView);
            Description = itemView.findViewById(R.id.DescriptionView);
            Goal = itemView.findViewById(R.id.GoalView);
            StartDate = itemView.findViewById(R.id.StartDateView);
            EndDate= itemView.findViewById(R.id.EndDateView);
        }
    }
    public Adapter(ArrayList<card> exampleList) {
        mExampleList = exampleList;
    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_detils, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        card currentReminder = mExampleList.get(position);
        holder.ProjectName.setText(currentReminder.getProjectName());
        holder.Description.setText(currentReminder.getDescription());
        holder.Goal.setText(currentReminder.getGoal());
        holder.StartDate.setText(currentReminder.getStartDate());
        holder.EndDate.setText(currentReminder.getEndDate());

    }
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
