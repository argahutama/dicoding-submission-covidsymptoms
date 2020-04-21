package com.arga;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;

public class CovidSymptomLists extends RecyclerView.Adapter<CovidSymptomLists.ListViewHolder> {
    private ArrayList<Symptoms> listSymptoms;
    private OnItemClickCallback onItemClickCallback;

    void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    CovidSymptomLists(ArrayList<Symptoms> list) {
        this.listSymptoms = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_symptoms, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Symptoms hero = listSymptoms.get(position);

        Glide.with(holder.itemView.getContext())
                .load(hero.getSymptomPictures())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.pictureSymptoms);

        holder.tvSymptoms.setText(hero.getSymptoms());
        holder.tvSymptomDetails.setText(hero.getSymptomDetails());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listSymptoms.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSymptoms.size();
    }


    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvSymptoms, tvSymptomDetails;
        ImageView pictureSymptoms;

        ListViewHolder(View itemView) {
            super(itemView);
            pictureSymptoms = itemView.findViewById(R.id.img_symptom);
            tvSymptoms = itemView.findViewById(R.id.tv_symptom);
            tvSymptomDetails = itemView.findViewById(R.id.tv_symptom_details);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Symptoms data);
    }
}