package com.example.a2502009715_mcs_uas;

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

import java.util.ArrayList;

public class Match extends Fragment {
    private RecyclerView recycle;
    private datahelper_match helper;
    private ArrayList<history_data> dataTemp_match = new ArrayList<>();
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycle = view.findViewById(R.id.recyclerMatch);
        helper = new datahelper_match(getContext());
        helper.addNewHistory("Manchester City F.C", "Premiere League", "Tommorow", "01:45 PM", R.drawable.logomancity, R.drawable.arsenal, "Man City", "Arsenal");
        helper.addNewHistory("Manchester City F.C", "Premiere League", "Tommorow", "01:45 PM", R.drawable.logomancity, R.drawable.arsenal, "Man City", "Arsenal");
        dataTemp_match = helper.dataOutput();

//        Log.i("dataMatch", "Title : " + dataTemp_match.get(0).getMainTitle());
        recycle.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        adapter_match adapterData = new adapter_match(helper.dataOutput(), getContext());
        recycle.setAdapter(adapterData);
    }
}