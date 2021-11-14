package com.example.ntumobile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class social_jio_sports_sessionAdapter extends RecyclerView.Adapter<social_jio_sports_sessionAdapter.MyViewHolder> implements Filterable {


    Context context;
    ArrayList<social_jio_sports_session> list;
    ArrayList<social_jio_sports_session> listFull;
    private OnItemClickListener mListener;
    private FilterActivity activityFilter;

    public social_jio_sports_sessionAdapter(Context context, ArrayList<social_jio_sports_session> list) {
        this.context = context;
        this.list = list;
        this.listFull = new ArrayList<>(list);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_social_jio_sports_session,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        social_jio_sports_session user = list.get(position);
        holder.activity.setText(user.getActivity());
        holder.location.setText(user.getLocation());
        holder.time.setText(user.getTime());
        holder.pax.setText(user.getPax());
        holder.currpax.setText(user.getCurrPax());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListener() {
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView activity, location, time, pax,currpax;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            activity = itemView.findViewById(R.id.tvActivity);
            location = itemView.findViewById(R.id.tvLocation);
            time = itemView.findViewById(R.id.tvtime);
            pax = itemView.findViewById(R.id.tvpax);
            currpax = itemView.findViewById(R.id.tvcurrpax);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            mListener.onItemClick(position);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    @Override
    public Filter getFilter() {
        if (activityFilter == null)
            activityFilter = new FilterActivity(this, list);
        return activityFilter;
    }
}