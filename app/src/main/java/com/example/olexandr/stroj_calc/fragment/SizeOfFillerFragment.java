package com.example.olexandr.stroj_calc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.olexandr.stroj_calc.R;

/**
 * Created by olexandr on 25.01.16.
 */
public class SizeOfFillerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.size_of_filler_fragment, container, false);

        return view;
    }
}