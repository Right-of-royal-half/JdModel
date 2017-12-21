package jingou.jo.com.myshixun2xm.adpter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import jingou.jo.com.myshixun2xm.Bean.FLrightBean;
import jingou.jo.com.myshixun2xm.R;

/**
 * Created by 杨杰 on 2017/12/15.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<FLrightBean.DataBean> list;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.zirv_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder= (MyViewHolder) holder;

        List<FLrightBean.DataBean.ListBean> list1 = this.list.get(position).getList();
        String name = list.get(position).getName();
        myViewHolder.tv.setText(name);
        for (int i = 0; i <list.size() ; i++) {

            myViewHolder.rlv3.setLayoutManager(new GridLayoutManager(context,3));
        }

        myViewHolder.rlv3.setAdapter(null);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv;
        private final RecyclerView rlv3;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tvTile);
            rlv3 = itemView.findViewById(R.id.rlv3);
        }
    }
}
