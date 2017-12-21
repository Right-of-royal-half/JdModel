package jingou.jo.com.myshixun2xm.adpter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import jingou.jo.com.myshixun2xm.Bean.FlleftBean;
import jingou.jo.com.myshixun2xm.R;

/**
 * Created by 杨杰 on 2017/12/13.
 */

public class leftfladpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<FlleftBean.DataBean> list;
    private Context context;
    private OnClienkListener onClienkListener;
    public interface OnClienkListener{
        void onClick(FlleftBean.DataBean dataBean1);
    }
    public void setOnClienkListener(OnClienkListener onClienkListener) {

        this.onClienkListener = onClienkListener;

    }

    public leftfladpter(List<FlleftBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.left_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        final FlleftBean.DataBean dataBean = list.get(position);
        myViewHolder.tv.setText(dataBean.getName());
        //自己加的属性用来判断电机

        if (dataBean.isChecked()) {

            myViewHolder.tv.setTextColor(Color.parseColor("#ff3306"));

        } else {

            myViewHolder.tv.setTextColor(Color.parseColor("#FF262426"));

        }

        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                if(onClienkListener!=null){
                    FlleftBean.DataBean dataBean1 = list.get(position);
                    onClienkListener.onClick(dataBean1);
                }



            }

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


      class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv;
        private final LinearLayout ll;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.left_tv);
            ll = itemView.findViewById(R.id.ll);
        }
    }
    public void press(int position){

        for (int i=0;i<list.size();i++){

            FlleftBean.DataBean dataBean = list.get(i);

            dataBean.setChecked(false);

        }

        FlleftBean.DataBean dataBean = list.get(position);

        dataBean.setChecked(true);

        notifyDataSetChanged();

    }
}
