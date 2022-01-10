package com.example.unistundenplan.ui.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unistundenplan.R;

import java.util.ArrayList;

public class TimetableAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<Object> elements;

    public TimetableAdapter(ArrayList<Object> elements) {
        this.elements = elements;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lesson_item,parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder {
        public View lessonView;
        public final TextView name;
        public final TextView begin;
        public final TextView end;
        public final TextView prof;
        public final TextView type;

        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            lessonView = itemView;
            name = itemView.findViewById(R.id.lesson_name);
            begin = itemView.findViewById(R.id.lesson_begin);
            end = itemView.findViewById(R.id.lesson_end);
            prof = itemView.findViewById(R.id.prof);
            type = itemView.findViewById(R.id.type);
        }
    }
}
