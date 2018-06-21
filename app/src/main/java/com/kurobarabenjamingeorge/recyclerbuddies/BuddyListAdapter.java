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
    BuddyListItemClickListener mListener;

    public interface BuddyListItemClickListener{
        void OnBuddyImageClick(int position);
        void OnBuddyTitleClick(int position);
    }

    public BuddyListAdapter(ArrayList<Buddy> buddies, Context ctx, BuddyListItemClickListener listener){
        this.buddies = buddies;
        this.ctx = ctx;
        this.mListener = listener;
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView buddyImg;
        private TextView buddyName, buddyDesc;

        public ViewHolder(View itemView) {
            super(itemView);

            buddyImg = (ImageView) itemView.findViewById(R.id.list_item_img);
            buddyName= (TextView) itemView.findViewById(R.id.list_item_title);
            buddyDesc = (TextView) itemView.findViewById(R.id.list_item_desc);

            buddyImg.setOnClickListener(this);
            buddyName.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.list_item_img){
                mListener.OnBuddyImageClick(getAdapterPosition());
            }else if(view.getId() == R.id.list_item_title){
                mListener.OnBuddyTitleClick(getAdapterPosition());
            }
        }
    }
}
