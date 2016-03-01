package com.example.olexandr.stroj_calc.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.text.InputType;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

import com.example.olexandr.stroj_calc.R;
import com.example.olexandr.stroj_calc.activity.StorageActivity;

/**
 * Created by olexandr on 24.01.16.
 */
public class CutFragment extends Fragment implements OnClickListener {

    private Button mStorage, mAdd, mResult;
    LinearLayout ll;
    TableLayout tl;
    int index = 0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cut_fragment, container, false);
        mStorage = (Button) view.findViewById(R.id.btn_storage_CutF);
        mAdd = (Button) view.findViewById(R.id.btn_add_CutF);
        mResult = (Button) view.findViewById(R.id.btn_result_CutF);
        mStorage.setOnClickListener(this);
        mAdd.setOnClickListener(this);
        mResult.setOnClickListener(this);
        ll = (LinearLayout) view.findViewById(R.id.ll_CutF);
        tl = (TableLayout) view.findViewById(R.id.tr_CutF);

        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_CutF: {


                LayoutParams viewParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);

                final TableRow tr = new TableRow(v.getContext());
                tr.setLayoutParams(viewParams);
                tr.setPadding(0, 0, 0, 5);
                tr.setId(index);


                InputFilter[] FilterArray = new InputFilter[1];
                FilterArray[0] = new InputFilter.LengthFilter(5);


                EditText etNumber = new EditText(v.getContext());
                etNumber.setLayoutParams(viewParams);
                etNumber.setTextColor(Color.BLACK);
                etNumber.setWidth(120);
                etNumber.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                etNumber.setFilters(FilterArray);
                etNumber.setId(1 + index);

                EditText etLength = new EditText(v.getContext());
                etLength.setLayoutParams(viewParams);
                etLength.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                etLength.setTextColor(Color.BLACK);
                etLength.setWidth(130);
                etLength.setFilters(FilterArray);
                etLength.setId(2 + index);

                final TextView tvNumber = new TextView(v.getContext());
                tvNumber.setText(R.string.number);
                tvNumber.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                tvNumber.setLayoutParams(viewParams);

                final TextView tvLength = new TextView(v.getContext());
                tvLength.setText(R.string.length);
                tvLength.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                tvLength.setLayoutParams(viewParams);

                final ImageButton btnIndetefication = new ImageButton(v.getContext());
                btnIndetefication.setImageResource(R.drawable.indentificstion);
                btnIndetefication.setLayoutParams(viewParams);
                btnIndetefication.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                btnIndetefication.setId(4 + index);

                final ImageButton btnDelete = new ImageButton(v.getContext());
                btnDelete.setImageResource(R.drawable.basket);
                btnDelete.setLayoutParams(viewParams);
                btnDelete.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btnDelete.setId(index);
                btnDelete.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        final TableRow parent = (TableRow) v.getParent();
                        tl.removeView(parent);


                    }

                });


                    tr.addView(tvNumber, 0);
                    tr.addView(etNumber, 1);
                    tr.addView(tvLength, 2);
                    tr.addView(etLength, 3);
                    tr.addView(btnIndetefication, 4);
                    tr.addView(btnDelete, 5);
                    tl.addView(tr, 0);

                    index++;
                    break;
                }
                case R.id.btn_storage_CutF: {
                    Intent runStorage = new Intent(v.getContext(), StorageActivity.class);
                    v.getContext().startActivity(runStorage);
                }
                case R.id.btn_result_CutF: {

                }
            }
        }
    }
