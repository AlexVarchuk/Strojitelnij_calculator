//package com.example.olexandr.stroj_calc.adapter;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//
//import com.example.olexandr.stroj_calc.R;
//import com.example.olexandr.stroj_calc.adapter.viewHolder.ConcreteViewHolder;
//import com.example.olexandr.stroj_calc.model.ConcreteModel;
//
//import java.util.List;
//
///**
// * Created by olexandr on 23.01.16.
// */
//public class ConcreteRecyclerAdapter extends RecyclerView.Adapter<ConcreteViewHolder> {
//
//
//    private AdapterView.OnItemClickListener listener;
//    List<ConcreteModel> mPartConcrete;
//    Context mContext;
//
//
//    public ConcreteRecyclerAdapter(Context _context, List<ConcreteModel> _partConcrete) {
//        mContext = _context;
//        mPartConcrete = _partConcrete;
//    }
//
//
//
//
//    @Override
//    public ConcreteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_beton, parent, false);
//        ConcreteViewHolder concrete = new ConcreteViewHolder(v);
//        return concrete;
//    }
//
//    @Override
//    public void onBindViewHolder(ConcreteViewHolder holder, int position) {
//
//        ConcreteModel model = mPartConcrete.get(position);
//        holder.onBind(model, position, mContext);
//
//
////Dorobiti
//    }
//
//    @Override
//    public int getItemCount() {
//        return mPartConcrete.size();
//    }
//
//
//
//
//
//}