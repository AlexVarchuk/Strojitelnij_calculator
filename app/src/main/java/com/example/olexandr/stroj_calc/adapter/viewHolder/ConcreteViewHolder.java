//package com.example.olexandr.stroj_calc.adapter.viewHolder;
//
//import android.content.Context;
//import android.content.Intent;
//import android.support.v7.widget.CardView;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//
//import com.example.olexandr.stroj_calc.R;
//import com.example.olexandr.stroj_calc.activity.ConcreteResult;
//import com.example.olexandr.stroj_calc.model.ConcreteModel;
//
///**
// * Created by olexandr on 23.01.16.
// */
//public class ConcreteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//    private CardView card;
//    private ImageView icon;
//    private Button part;
//    private Context context;
//
//
//
//
//    public ConcreteViewHolder(View itemView) {
//        super(itemView);
//        card = (CardView) itemView.findViewById(R.id.cv);
//        icon = (ImageView) itemView.findViewById(R.id.iv_lib);
//        part = (Button) itemView.findViewById(R.id.btn_lib);
//        part.setOnClickListener(this);
//
//
//
//    }
//
//
//
//    @Override
//    public void onClick(View v) {
//        switch (getAdapterPosition()) {
//            case 0: {
//                Intent intent =  new Intent(v.getContext(), ConcreteSizeAndTypeActivity.class);
//                v.getContext().startActivity(intent);
//            }
//            case 1: {
//                Intent intent =  new Intent(v.getContext(), ConcreteMarkActivity.class);
//                v.getContext().startActivity(intent);
//            }
//            case 2: {
//                Intent intent =  new Intent(v.getContext(), ConcreteSizeOfFillerActivity.class);
//                v.getContext().startActivity(intent);
//            }
//            case 3: {
//                Intent intent =  new Intent(v.getContext(), ConcreteResult.class);
//                v.getContext().startActivity(intent);
//            }
//        }
//
//
//    }
//
//
//
//
//    public void onBind(ConcreteModel model, int position, Context mContext) {
//
//        part.setText(model.getItem());
//    }
//
//
//}
