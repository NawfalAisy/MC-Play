package com.example.a2502009715_mcs_uas;

import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView recycle;
    private databaseHelper helper;
    private ArrayList<articles> dataTemp_article = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycle = view.findViewById(R.id.recyclerhome);
        helper = new databaseHelper(getContext());
        helper.addNewArticle("Haaland confident Man City will beat Arsenal to league title", R.drawable.articlesimage);
        helper.addNewArticle("Haaland confident Man City will beat Arsenal to league title", R.drawable.articlesimage);
        dataTemp_article = helper.dataOutput();

        Log.i("data Inserted", "Image: " + dataTemp_article.get(0).getImage() + "\n" + "Name: " + dataTemp_article.get(0).getName());
        recycle.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        Adapter adapter = new Adapter(getContext(), helper.dataOutput());
        recycle.setAdapter(adapter);
    }
}