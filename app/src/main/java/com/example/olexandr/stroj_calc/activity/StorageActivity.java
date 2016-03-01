package com.example.olexandr.stroj_calc.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.example.olexandr.stroj_calc.R;

/**
 * Created by olexandr on 27.02.16.
 */
public class StorageActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_storage);
    }
}
