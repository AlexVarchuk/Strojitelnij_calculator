//package com.example.olexandr.stroj_calc.adapter;
//
//import android.content.Context;
//import android.support.v7.widget.CardView;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.example.olexandr.stroj_calc.R;
//import com.example.olexandr.stroj_calc.model.ConcreteModel;
//
//import java.util.List;
//
///**
// * Created by olexandr on 04.02.16.
// */
//public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
//    List<ConcreteModel> mPartConcrete;
//    Context mContext;
//    private OnItemClickListener listener;
//
//    public RecyclerViewAdapter(Context _context, List<ConcreteModel> _partConcrete) {
//        this.mContext = _context;
//        this.mPartConcrete = _partConcrete;
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder  {
//        public Button part;
//        public CardView cardView;
//        private OnItemClickListener listener;
//        private OnItemClickListener onItemClickListener;
//
//        public ViewHolder(View v) {
//            super(v);
//
//
//            final Context context = v.getContext();
//            cardView = (CardView) v.findViewById(R.id.cv);
//            part = (Button) v.findViewById(R.id.btn_lib);
//
//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(listener!=null) {
//                        listener.onItemClick(part.getText().toString());
//                    }
//                }
//            });
//
//        }
//
//
//
//        public void onBind(ConcreteModel model, int position, Context mContext) {
//            part.setText(model.getItem());
//
//        }
//
//
//        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
//            this.onItemClickListener = onItemClickListener;
//        }
//
//
//    }
//
//
//    @Override
//    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
//                                                             int viewType) {
//        View v = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.list_item_beton, parent, false);
//        return new ViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//
//        ConcreteModel model = mPartConcrete.get(position);
//        holder.onBind(model, position, mContext);
//        holder.setOnItemClickListener(listener);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return mPartConcrete.size();
//    }
//
//
//    public void setOnItemClickListener(OnItemClickListener listener) {
//        this.listener = listener;
//    }
//
//    public interface OnItemClickListener {
//        public void onItemClick(String text);
//    }
//}
