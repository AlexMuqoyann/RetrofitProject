package com.example.hp.retrofitproject3.adpters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.retrofitproject3.R;
import com.example.hp.retrofitproject3.models.Contact;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 17.01.2018.
 */

public class Row2adapter extends RecyclerView.Adapter<Row2adapter.ViewHolder> {
    private List<Contact> list;
    private Context context;
    private LayoutInflater inflater;
    public Row2adapter(Context context, ArrayList<Contact> list) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.list = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row2, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = list.get(position);
        holder.row2_name.setText(contact.getName());
        holder.row2_email.setText(contact.getEmail());
        Picasso.with(context).load(contact.getProfilePic()).into(holder.row2_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        private ImageView row2_image;
        private TextView row2_email;
        private TextView row2_name;
        public ViewHolder(View itemView) {
            super(itemView);

            row2_image = itemView.findViewById(R.id.row2_image);
            row2_email = itemView.findViewById(R.id.row2_email);
            row2_name = itemView.findViewById(R.id.row2_name);
        }
    }
}
