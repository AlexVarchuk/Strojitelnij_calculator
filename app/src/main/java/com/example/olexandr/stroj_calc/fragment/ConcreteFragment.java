package com.example.olexandr.stroj_calc.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.olexandr.stroj_calc.R;
import com.example.olexandr.stroj_calc.model.ConcreteModel;

import java.util.List;

/**
 * Created by olexandr on 20.01.16.
 */
public class ConcreteFragment extends Fragment {

//    private RecyclerView mConcreteList;
//    private RecyclerView.LayoutManager mLayoutManager;
//    private ConcreteRecyclerAdapter mConcreteAdapter;
//    private List<ConcreteModel> partConcrete;
    LinearLayout mLSize, mLMark, mLSizeOfFiller, mLPrice, mLREsult;
    boolean isFullView = true;
    boolean go = true;
    Button mSize, mMark, mSizeOfFiller, mPrice, mResult;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.concrete_fragment, container, false);

        mSize = (Button) view.findViewById(R.id.btn_size_CF);
        mMark = (Button) view.findViewById(R.id.btn_concrete_mark_CF);
        mSizeOfFiller = (Button) view.findViewById(R.id.btn_size_of_filler_CF);
        mPrice = (Button) view.findViewById(R.id.btn_price_CF);

        mLSize = (LinearLayout) view.findViewById(R.id.ll_size);
        mLMark = (LinearLayout) view.findViewById(R.id.ll_concrete_mark_CF);
        mLSizeOfFiller = (LinearLayout) view.findViewById(R.id.ll_size_of_filler_CF);
        mLPrice = (LinearLayout) view.findViewById(R.id.ll_price_CF);

        mSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (go) {
                    mLSize.setVisibility(View.VISIBLE);
                    mLSizeOfFiller.setVisibility(View.GONE);
                    mLMark.setVisibility(View.GONE);
                    mLPrice.setVisibility(View.GONE);
                    go = false;
                } else {
                    mLSize.setVisibility(View.GONE);
                    mLSizeOfFiller.setVisibility(View.GONE);
                    mLMark.setVisibility(View.GONE);
                    mLPrice.setVisibility(View.GONE);
                    go = true;
                }
            }
        });
        mMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (go) {
                    mLSize.setVisibility(View.GONE);
                    mLSizeOfFiller.setVisibility(View.GONE);
                    mLMark.setVisibility(View.VISIBLE);
                    mLPrice.setVisibility(View.GONE);
                    go = false;
                } else {
                    mLSize.setVisibility(View.GONE);
                    mLSizeOfFiller.setVisibility(View.GONE);
                    mLMark.setVisibility(View.GONE);
                    mLPrice.setVisibility(View.GONE);
                    go = true;
                }
            }
        });
        mSizeOfFiller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (go) {
                    mLSize.setVisibility(View.GONE);
                    mLSizeOfFiller.setVisibility(View.VISIBLE);
                    mLMark.setVisibility(View.GONE);
                    mLPrice.setVisibility(View.GONE);
                    go = false;
                } else {
                    mLSize.setVisibility(View.GONE);
                    mLSizeOfFiller.setVisibility(View.GONE);
                    mLMark.setVisibility(View.GONE);
                    mLPrice.setVisibility(View.GONE);
                    go = true;
                }
            }
        });
        mPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (go) {
                    mLSize.setVisibility(View.GONE);
                    mLSizeOfFiller.setVisibility(View.GONE);
                    mLMark.setVisibility(View.GONE);
                    mLPrice.setVisibility(View.VISIBLE);
                    go = false;
                } else {
                    mLSize.setVisibility(View.GONE);
                    mLSizeOfFiller.setVisibility(View.GONE);
                    mLMark.setVisibility(View.GONE);
                    mLPrice.setVisibility(View.GONE);
                    go = true;
                }
            }
        });

//        partConcrete = new ArrayList<>();
//        initializeData();
//        mLayoutManager = new LinearLayoutManager(getActivity());
//        //mConcreteList = (RecyclerView) view.findViewById(R.id.rv_BF);
//        mConcreteList.setHasFixedSize(true);
//        mConcreteList.setLayoutManager(mLayoutManager);
//
//
//        mConcreteAdapter = new ConcreteRecyclerAdapter(getContext(), partConcrete);
//
//        mConcreteList.setAdapter(mConcreteAdapter);

        return view;


    }

//    private void initializeData() {
//
//        partConcrete.add(new ConcreteModel(R.string.name_button_size, R.drawable.size));
//        partConcrete.add(new ConcreteModel(R.string.name_button_mark_concrete, R.drawable.setka));
//        partConcrete.add(new ConcreteModel(R.string.name_button_size_of_filler, R.drawable.setka));
//        partConcrete.add(new ConcreteModel(R.string.name_button_result, R.drawable.setka));
//    }


}
