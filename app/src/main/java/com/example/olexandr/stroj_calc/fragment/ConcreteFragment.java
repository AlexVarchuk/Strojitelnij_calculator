package com.example.olexandr.stroj_calc.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.olexandr.stroj_calc.R;

import java.math.BigDecimal;

/**
 * Created by olexandr on 20.01.16.
 */
public class ConcreteFragment extends Fragment {

    //    private RecyclerView mConcreteList;
//    private RecyclerView.LayoutManager mLayoutManager;
//    private ConcreteRecyclerAdapter mConcreteAdapter;
//    private List<ConcreteModel> partConcrete;
    private LinearLayout mLSize, mLMark, mLSizeOfFiller, mLPrice, mLResult;
    private boolean go = true;
    private Button mSize, mMark, mSizeOfFiller, mPrice, mResult;
    private EditText mX, mY, mZ, mPriceCement, mPriceSand, mPriceFiller;
    private RadioGroup mMarkConcrete, mSizeFiller, mFiller;
    private TextView massCement, massWater, massScree, massSand, mRatio, mFinalPriceCement, mFinalPriceSand, mFinalPriceFiller, mTVVolume;

    private int mWater;
    private int mCement;
    private double mVCement;
    private int mRatioCement;
    private double mVolume;
    private int mPercentageScree;
    private int mDensityConcrete = 2400;
    private boolean mTypeFiller = true;
    private double mScree;
    private int mS;
    private double mSand;
    private double mVScree, mVWater;
    private double mVSand;
    private double mRatioSand;
    private double mRatioScree;
    double priceCement, priceSand, priceFiller;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.concrete_fragment, container, false);
        findViews(view);


        mMarkConcrete.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mWater = 0;
                mCement = 0;
                switch (checkedId) {

                    case R.id.rb_m100_CF: {
                        mWater = 150;
                        mCement = 180;
                        break;
                    }
                    case R.id.rb_m150_CF: {
                        mWater = 150;
                        mCement = 200;
                        break;
                    }
                    case R.id.rb_m200_CF: {
                        mWater = 163;
                        mCement = 260;
                        break;
                    }
                    case R.id.rb_m250_CF: {
                        mWater = 170;
                        mCement = 320;
                        break;
                    }
                    case R.id.rb_m300_CF: {
                        mWater = 170;
                        mCement = 350;
                        break;
                    }
                    case R.id.rb_m350_CF: {
                        mWater = 180;
                        mCement = 380;
                        break;
                    }
                    case R.id.rb_m400_CF: {
                        mWater = 200;
                        mCement = 440;
                        break;
                    }
                }

            }
        });
        mSizeFiller.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.rb_10_CF: {
                        checkSize10Filler();
                        mS = 10;
                        break;
                    }
                    case R.id.rb_40_CF: {
                        checkSize40Filler();
                        mS = 40;
                        break;
                    }
                    case R.id.rb_60_CF: {
                        checkSize60Filler();
                        mS = 60;
                        break;
                    }
                    case R.id.rb_80_CF: {
                        checkSize80Filler();
                        mS = 80;
                        break;

                    }

                }
                //Toast.makeText(getContext(), "" + mPercentageScree, Toast.LENGTH_SHORT).show();
                checkValue();
            }

        });
        mFiller.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mTypeFiller = true;
                switch (checkedId) {
                    case R.id.rb_grid_CF: {
                        mTypeFiller = true;
                        break; //gravij
                    }
                    case R.id.rb_scree_CF: {
                        mTypeFiller = false;
                        Toast.makeText(getContext(), "" + mTypeFiller, Toast.LENGTH_SHORT).show();
                        break;
                        //4ebin
                    }
                }
                checkValue();
            }
        });

        mSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (go) {
                    mLSize.setVisibility(View.VISIBLE);
                    mLSizeOfFiller.setVisibility(View.GONE);
                    mLMark.setVisibility(View.GONE);
                    mLPrice.setVisibility(View.GONE);
                    mLResult.setVisibility(View.GONE);

                    go = false;
                } else {
                    mLSize.setVisibility(View.GONE);
                    checkValue();
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
                    mLResult.setVisibility(View.GONE);
                    go = false;
                } else {

                    mLMark.setVisibility(View.GONE);
                    checkValue();
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
                    mLResult.setVisibility(View.GONE);
                    go = false;
                } else {

                    mLSizeOfFiller.setVisibility(View.GONE);
                    checkValue();
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
                    mLResult.setVisibility(View.GONE);
                    go = false;
                } else {
//                    mLSize.setVisibility(View.GONE);
//                    mLSizeOfFiller.setVisibility(View.GONE);
//                    mLMark.setVisibility(View.GONE);
                    mLPrice.setVisibility(View.GONE);
//                    mLREsult.setVisibility(View.GONE);
                    checkValue();
                    go = true;
                }
            }
        });
        mResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (go) {
                    mLSize.setVisibility(View.GONE);
                    mLSizeOfFiller.setVisibility(View.GONE);
                    mLMark.setVisibility(View.GONE);
                    mLPrice.setVisibility(View.GONE);
                    mLResult.setVisibility(View.VISIBLE);
                    go = false;
                    findVolume();
                    checkSizeFiller();


                    mSand = (mDensityConcrete - mCement - mWater) * mPercentageScree / 100;
                    mScree = (mDensityConcrete - mCement - mWater - mSand);
                    determineTheProportions();
                    calculatePrice();


                    mRatio.setText(String.valueOf(roundUp(mRatioCement, 1)) + ": " + String.valueOf(roundUp(mRatioSand, 1)) + ": " + String.valueOf(roundUp(mRatioScree, 1)));
                    massWater.setText("" + Math.round(mWater * mVolume));
                    massCement.setText("" + Math.round(mCement * mVolume));
                    massSand.setText("" + Math.round(mSand * mVolume));
                    massScree.setText("" + Math.round(mScree * mVolume));
                    mTVVolume.setText(String.valueOf(roundUp(mVolume, 1)));
                    if (priceCement != 0 && priceSand != 0 && priceFiller != 0) {
                        mFinalPriceCement.setText(String.valueOf(roundUp(priceCement, 1)));
                        mFinalPriceSand.setText(String.valueOf(roundUp(priceSand, 1)));
                        mFinalPriceFiller.setText(String.valueOf(roundUp(priceFiller, 1)));
                        // Toast.makeText(getContext(), ""+mSand+"  "+mScree, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    mLSize.setVisibility(View.GONE);
                    mLSizeOfFiller.setVisibility(View.GONE);
                    mLMark.setVisibility(View.GONE);
                    mLPrice.setVisibility(View.GONE);
                    mLResult.setVisibility(View.GONE);
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

    private double calculatePrice() {
        if (mPriceFiller.getText().length() == 0 && mPriceSand.getText().length() == 0 && mPriceCement.getText().length() == 0) {

        } else {
            priceCement = Double.parseDouble(mPriceCement.getText().toString()) * mCement * mVolume;
            priceSand = Double.parseDouble(mPriceSand.getText().toString()) * mSand * mVolume;
            priceFiller = Double.parseDouble(mPriceFiller.getText().toString()) * mScree * mVolume;
            return priceCement + priceSand + priceFiller;
        }
        return Double.parseDouble(String.valueOf(0));
    }

    private void determineTheProportions() {
        float b = mCement;
        float c = 1300;
        mVCement = b / c;
        mVScree = mScree / 1350;
        mVSand = mSand / 1400;
        mVWater = mWater / 1000;
        mRatioCement = 1;
        mRatioScree = mVScree / mVCement;
        mRatioSand = mVSand / mVCement;


    }

    private void checkSizeFiller() {
        if (mS == 10) {
            checkSize10Filler();
        }
        if (mS == 40) {
            checkSize40Filler();
        }
        if (mS == 60) {
            checkSize60Filler();
        }
        if (mS == 80) {
            checkSize80Filler();
        }


    }

    private void checkSize80Filler() {
        if (mCement == 180) {
            if (mTypeFiller) {
                mPercentageScree = 35;
            } else {
                mPercentageScree = 37;
            }
        } else if (mCement == 200) {
            if (mTypeFiller) {
                mPercentageScree = 35;
            } else {
                mPercentageScree = 37;
            }
        } else if (mCement == 260) {
            if (mTypeFiller) {
                mPercentageScree = 33;
            } else {
                mPercentageScree = 36;
            }
        } else if (mCement == 320) {
            if (mTypeFiller) {
                mPercentageScree = 31;
            } else {
                mPercentageScree = 34;
            }
        } else if (mCement == 350) {
            if (mTypeFiller) {
                mPercentageScree = 28;
            } else {
                mPercentageScree = 31;
            }
        } else if (mCement == 380) {
            if (mTypeFiller) {
                mPercentageScree = 27;
            } else {
                mPercentageScree = 30;
            }
        } else if (mCement == 440) {
            if (mTypeFiller) {
                mPercentageScree = 13;
            } else {
                mPercentageScree = 29;
            }
        }
    }

    private void checkSize60Filler() {
        if (mCement == 180) {
            if (mTypeFiller) {
                mPercentageScree = 36;
            } else {
                mPercentageScree = 39;
            }
        } else if (mCement == 200) {
            if (mTypeFiller) {
                mPercentageScree = 36;
            } else {
                mPercentageScree = 39;
            }
        } else if (mCement == 260) {
            if (mTypeFiller) {
                mPercentageScree = 35;
            } else {
                mPercentageScree = 38;
            }
        } else if (mCement == 320) {
            if (mTypeFiller) {
                mPercentageScree = 33;
            } else {
                mPercentageScree = 35;
            }
        } else if (mCement == 350) {
            if (mTypeFiller) {
                mPercentageScree = 30;
            } else {
                mPercentageScree = 33;
            }
        } else if (mCement == 380) {
            if (mTypeFiller) {
                mPercentageScree = 29;
            } else {
                mPercentageScree = 32;
            }
        } else if (mCement == 440) {
            if (mTypeFiller) {
                mPercentageScree = 28;
            } else {
                mPercentageScree = 31;
            }
        }
    }

    private void checkSize40Filler() {
        if (mCement == 180) {
            if (mTypeFiller) {
                mPercentageScree = 38;
            } else {
                mPercentageScree = 42;
            }
        } else if (mCement == 200) {
            if (mTypeFiller) {
                mPercentageScree = 38;
            } else {
                mPercentageScree = 42;
            }
        } else if (mCement == 260) {
            if (mTypeFiller) {
                mPercentageScree = 37;
            } else {
                mPercentageScree = 41;
            }
        } else if (mCement == 320) {
            if (mTypeFiller) {
                mPercentageScree = 33;
            } else {
                mPercentageScree = 39;
            }
        } else if (mCement == 350) {
            if (mTypeFiller) {
                mPercentageScree = 32;
            } else {
                mPercentageScree = 36;
            }
        } else if (mCement == 380) {
            if (mTypeFiller) {
                mPercentageScree = 31;
            } else {
                mPercentageScree = 35;
            }
        } else if (mCement == 440) {
            if (mTypeFiller) {
                mPercentageScree = 29;
            } else {
                mPercentageScree = 33;
            }
        }

    }

    private void checkSize10Filler() {
        if (mCement == 180) {
            if (mTypeFiller) {
                mPercentageScree = 40;

            } else {
                mPercentageScree = 46;

            }
        } else if (mCement == 200) {
            if (mTypeFiller) {
                mPercentageScree = 40;

            } else {
                mPercentageScree = 46;

            }
        } else if (mCement == 260) {
            if (mTypeFiller) {
                mPercentageScree = 37;

            } else {
                mPercentageScree = 45;

            }
        } else if (mCement == 320) {
            if (mTypeFiller) {
                mPercentageScree = 37;

            } else {
                mPercentageScree = 43;

            }
        } else if (mCement == 350) {
            if (mTypeFiller) {
                mPercentageScree = 35;

            } else {
                mPercentageScree = 40;

            }
        } else if (mCement == 380) {
            if (mTypeFiller) {
                mPercentageScree = 34;

            } else {
                mPercentageScree = 38;

            }
        } else if (mCement == 440) {
            if (mTypeFiller) {
                mPercentageScree = 32;

            } else {
                mPercentageScree = 35;
            }
        }


    }

    private void findViews(View view) {
        mSize = (Button) view.findViewById(R.id.btn_size_CF);
        mMark = (Button) view.findViewById(R.id.btn_concrete_mark_CF);
        mSizeOfFiller = (Button) view.findViewById(R.id.btn_size_of_filler_CF);
        mPrice = (Button) view.findViewById(R.id.btn_price_CF);
        mResult = (Button) view.findViewById(R.id.btn_result_CF);

        mMarkConcrete = (RadioGroup) view.findViewById(R.id.rg_mark_CM);
        mSizeFiller = (RadioGroup) view.findViewById(R.id.rg_size_of_filler_CF);
        mFiller = (RadioGroup) view.findViewById(R.id.rg_filler_CF);

        mX = (EditText) view.findViewById(R.id.et_x_CM);
        mY = (EditText) view.findViewById(R.id.et_y_CM);
        mZ = (EditText) view.findViewById(R.id.et_z_CM);
        mPriceCement = (EditText) view.findViewById(R.id.et_price_cement_CM);
        mPriceSand = (EditText) view.findViewById(R.id.et_price_sand_CM);
        mPriceFiller = (EditText) view.findViewById(R.id.et_price_filler_CM);

        mLSize = (LinearLayout) view.findViewById(R.id.ll_size);
        mLMark = (LinearLayout) view.findViewById(R.id.ll_concrete_mark_CF);
        mLSizeOfFiller = (LinearLayout) view.findViewById(R.id.ll_size_of_filler_CF);
        mLPrice = (LinearLayout) view.findViewById(R.id.ll_price_CF);
        mLResult = (LinearLayout) view.findViewById(R.id.ll_result_CF);

        massCement = (TextView) view.findViewById(R.id.tv_cement_CF);
        massWater = (TextView) view.findViewById(R.id.tv_water_CF);
        massSand = (TextView) view.findViewById(R.id.tv_sand_CF);
        massScree = (TextView) view.findViewById(R.id.tv_scree_CF);
        mRatio = (TextView) view.findViewById(R.id.tv_ratio_CF);
        mTVVolume = (TextView) view.findViewById(R.id.tv_volume_CF);

        mFinalPriceCement = (TextView) view.findViewById(R.id.tv_final_price_cement_CF);
        mFinalPriceSand = (TextView) view.findViewById(R.id.tv_final_price_sand_CF);
        mFinalPriceFiller = (TextView) view.findViewById(R.id.tv_final_price_filler_CF);


    }

    private double findVolume() {
        float x, y, z;
        x = Float.parseFloat(mX.getText().toString());
        y = Float.parseFloat(mY.getText().toString());
        z = Float.parseFloat(mZ.getText().toString());
        mVolume = x * y * z;
        return mVolume;
    }


    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);


    }


    public void checkValue() {
        if (mCement == 0 || mWater == 0 || mPercentageScree == 0 || mS == 0) {
            mResult.setVisibility(View.GONE);
        } else {
            mResult.setVisibility(View.VISIBLE);
        }
    }

}
