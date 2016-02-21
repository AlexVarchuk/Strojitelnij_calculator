package com.example.olexandr.stroj_calc.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.olexandr.stroj_calc.R;

/**
 * Created by olexandr on 25.01.16.
 */
public class ConcreteSizeFragment extends Fragment {


    public static String TAG = "ConcreteSizeFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.concrete_size_fragment, container, false);

        return view;
    }
}