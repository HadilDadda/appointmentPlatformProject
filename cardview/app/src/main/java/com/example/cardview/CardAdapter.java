package com.example.cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<CardModel> cardModelArrayList;

    public CardAdapter(Context context, ArrayList<CardModel> cardModelArrayList) {
        this.context = context;
        this.cardModelArrayList = cardModelArrayList;
    }

    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
        CardModel model = cardModelArrayList.get(position);
        holder.empName.setText(model.getEmp_name());
        holder.empDescription.setText("" + model.getEmp_description());
        holder.empImage.setImageResource(model.getEmp_image());
    }

    @Override
    public int getItemCount() {
        return cardModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView empImage;
        private final TextView empName;
        private final TextView empDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            empImage = itemView.findViewById(R.id.empImage);
            empName = itemView.findViewById(R.id.empName);
            empDescription = itemView.findViewById(R.id.empDescription);
        }
    }
}
