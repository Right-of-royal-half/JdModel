package jingou.jo.com.myshixun2xm.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import jingou.jo.com.myshixun2xm.Bean.SPxiangqingBean;
import jingou.jo.com.myshixun2xm.R;

/**
 * Created by 杨杰 on 2017/12/18.
 */

public class Spxqadpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private SPxiangqingBean.DataBean list;

    OnAddCar onAddCar;

    public void setOnAddCar(OnAddCar onAddCar) {
        this.onAddCar = onAddCar;
    }

    public Spxqadpter(Context context, SPxiangqingBean.DataBean list) {
        this.context = context;
        this.list = list;
    }

    public interface  OnAddCar
    {
        public void addCar(int pid);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.spxq_zhitem, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv.setText(list.getSubhead());
        myViewHolder.price.setText( list.getPrice()+"");

        myViewHolder.addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddCar.addCar(list.getPid());
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv;
        private final TextView price;
        Button addCar;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_xq_item);
            price = itemView.findViewById(R.id.price);
            addCar=itemView.findViewById(R.id.jrgw);
        }
    }
}
