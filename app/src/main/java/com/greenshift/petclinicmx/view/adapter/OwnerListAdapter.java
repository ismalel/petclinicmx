package com.greenshift.petclinicmx.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.greenshift.petclinicmx.R;
import com.greenshift.petclinicmx.entity.Owner;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class OwnerListAdapter extends RecyclerView.Adapter<OwnerListAdapter.OwnerViewHolder> {

    private Context context;
    private ArrayList<Owner> ownerList = new ArrayList<>();

    public OwnerListAdapter(Context context,ArrayList<Owner> ownerList){
        this.context = context;
        this.ownerList = ownerList;
    }
    @NonNull
    @Override
    public OwnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.owner_list_item, parent, false);
        OwnerViewHolder holder = new OwnerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OwnerViewHolder holder, int position) {
        holder.id.setText("" + ownerList.get(position).getId());
        holder.name.setText(ownerList.get(position).getName());
        holder.img.setImageResource(ownerList.get(position).getAvatar());
    }


    @Override
    public int getItemCount() {
        return ownerList.size();
    }

    public class OwnerViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img;
        TextView id;
        TextView name;

        public OwnerViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.profile_image);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
        }
    }
}
