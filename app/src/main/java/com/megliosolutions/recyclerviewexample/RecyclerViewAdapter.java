package com.megliosolutions.recyclerviewexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Meglio on 2/13/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

        private List<Item> itemsList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView date;

            public MyViewHolder(View view) {
                super(view);
                date = (TextView) view.findViewById(R.id.date_textview);

            }
        }

        public RecyclerViewAdapter(List<Item> itemsList) {
            this.itemsList = itemsList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_listitem, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Item item = itemsList.get(position);
            holder.date.setText(item.getDate());
        }

        @Override
        public int getItemCount() {
            return itemsList.size();
        }
}
