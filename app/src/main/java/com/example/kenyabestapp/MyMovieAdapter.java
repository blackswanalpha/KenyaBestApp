package com.example.kenyabestapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyMovieAdapter extends RecyclerView.Adapter<MyMovieAdapter.ViewHolder> {

    MyMovieData[] myMovieData;
    Context context;
    private OnNoteListener mOnNoteListener;

    public MyMovieAdapter(MyMovieData[] myMovieData,Venues activity,OnNoteListener onNoteListener) {

        this.myMovieData = myMovieData;
        this.context = activity;
        this.mOnNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.movie_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view, mOnNoteListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MyMovieData myMovieDataList = myMovieData[position];
        holder.textViewName.setText(myMovieDataList.getMovieName());
        holder.textViewDate.setText(myMovieDataList.getMovieDate());
        holder.movieImage.setImageResource(myMovieDataList.getMovieImage());


    }

    @Override
    public int getItemCount() {
        return myMovieData.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        ImageView movieImage;
        TextView textViewName;
        TextView textViewDate;
        OnNoteListener mOnNoteListener;

        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.imageview);
            textViewName = itemView.findViewById(R.id.textName);
            textViewDate = itemView.findViewById(R.id.textdate);
            this.mOnNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            mOnNoteListener.onNoteClick(getAdapterPosition());
        }
    }
    public interface OnNoteListener{
        void onNoteClick(int position);
    }

}
