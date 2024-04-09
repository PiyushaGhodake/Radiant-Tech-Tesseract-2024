package com.example.pathsage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


public class HomeFragment extends Fragment {

    GridLayout mainGrid;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mainGrid = view.findViewById(R.id.mainGrid);

        // Set Event
        setSingleEvent(mainGrid);

        return view;
    }

    private void setSingleEvent(GridLayout mainGrid) {

        CardView cardViewG = (CardView) mainGrid.getChildAt(0);
        final int finalIG = 0;
        cardViewG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Arts.class);
                intent.putExtra("info", "This is activity from card item index " + finalIG);
                startActivity(intent);
            }
        });

        CardView cardViewF = (CardView) mainGrid.getChildAt(1);
        final int finalIF = 1;
        cardViewF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Science.class);
                intent.putExtra("info", "This is activity from card item index " + finalIF);
                startActivity(intent);
            }
        });

        CardView cardViewV = (CardView) mainGrid.getChildAt(2);
        final int finalIV = 2;
        cardViewV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Commerce.class);
                intent.putExtra("info", "This is activity from card item index " + finalIV);
                startActivity(intent);
            }
        });

        CardView cardViewFl = (CardView) mainGrid.getChildAt(3);
        final int finalIFl = 3;
        cardViewFl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Diploma.class);
                intent.putExtra("info", "This is activity from card item index " + finalIFl);
                startActivity(intent);
            }
        });
    }
}