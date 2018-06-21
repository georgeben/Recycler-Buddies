package com.kurobarabenjamingeorge.recyclerbuddies;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by George Benjamin on 6/21/2018.
 */

public class BuddyListAdapter extends RecyclerView.Adapter<BuddyListAdapter.ViewHolder> {

    private ArrayList<Buddy> buddies;
    private Context ctx;

    public BuddyListAdapter(ArrayList<Buddy> buddies, Context ctx){
        this.buddies = buddies;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View list_item_view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(list_item_view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Buddy buddy = buddies.get(position);
        holder.buddyImg.setImageResource(buddy.getImg_res());
        holder.buddyName.setText(buddy.getBuddy_name());
        holder.buddyDesc.setText(buddy.getBuddy_description());
    }

    @Override
    public int getItemCount() {
        return buddies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView buddyImg;
        private TextView buddyName, buddyDesc;

        public ViewHolder(View itemView) {
            super(itemView);

            buddyImg = (ImageView) itemView.findViewById(R.id.list_item_img);
            buddyName= (TextView) itemView.findViewById(R.id.list_item_title);
            buddyDesc = (TextView) itemView.findViewById(R.id.list_item_desc);
        }
    }
}
