package com.example.a2502009715_mcs_uas;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter_match extends RecyclerView.Adapter<adapter_match.ViewHolder> {
    ArrayList<history_data> history_datas = new ArrayList<>();
    Context context;

    public adapter_match(ArrayList<history_data> history_datas, Context context) {
        this.history_datas = history_datas;
        this.context = context;
    }

    @NonNull
    @Override
    public adapter_match.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.playmatch, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_match.ViewHolder holder, int position) {
        history_data temp = history_datas.get(position);
        holder.tittleMain.setText(temp.getMainTitle());
        holder.subMainTittle.setText(temp.getSubMainTitle());
        holder.time.setText(temp.getTime());
        holder.teamA.setText(temp.getTeamA());
        holder.date.setText(temp.getDate());
        holder.teamB.setText(temp.getTeamB());
        holder.teamA_image.setImageResource(temp.getImageTeamA());
        holder.teamB_image.setImageResource(temp.getImageTeamB());
    }

    @Override
    public int getItemCount() {
        return history_datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tittleMain, subMainTittle, teamA, teamB, date, time;
        private ImageView teamA_image, teamB_image;
        private Button buy;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tittleMain = itemView.findViewById(R.id.Main_text);
            subMainTittle = itemView.findViewById(R.id.sub_mainTitle);
            teamA = itemView.findViewById(R.id.teamA);
            teamB = itemView.findViewById(R.id.teamB);
            date = itemView.findViewById(R.id.date);
            buy = itemView.findViewById(R.id.buyTicket);
            time = itemView.findViewById(R.id.time);
            teamA_image = itemView.findViewById(R.id.teamA_image);
            teamB_image = itemView.findViewById(R.id.teamB_image);
        }
    }
}
