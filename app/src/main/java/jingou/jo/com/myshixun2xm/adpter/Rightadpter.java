package jingou.jo.com.myshixun2xm.adpter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import jingou.jo.com.myshixun2xm.Bean.FLrightBean;
import jingou.jo.com.myshixun2xm.R;

/**
 * Created by 杨杰 on 2017/12/14.
 */

public class Rightadpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<FLrightBean.DataBean> list;
    private Onclickitem onclickitem;

    public interface Onclickitem {
        void onClickitem(int position);
    }

    public void setonclick(Onclickitem onclickitem) {
        this.onclickitem = onclickitem;
    }

    public Rightadpter(Context context, List<FLrightBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        FLrightBean.DataBean dataBean = list.get(position);
        final List<FLrightBean.DataBean.ListBean> list1 = list.get(position).getList();
        myViewHolder.tv_right_item.setText(dataBean.getName());
        myViewHolder.rlv_right.setLayoutManager(new GridLayoutManager(context, 3));
        final Right_itemadpter right_itemadpter = new Right_itemadpter(context, list1);
        myViewHolder.rlv_right.setAdapter(right_itemadpter);
        right_itemadpter.setOnClickItemClick(new Right_itemadpter.OnClickItemClick() {
            @Override
            public void onClickitem(int position) {
                int pscid = list1.get(position).getPscid();
                onclickitem.onClickitem(pscid);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_right_item;
        private final RecyclerView rlv_right;
        private final LinearLayout ll;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_right_item = itemView.findViewById(R.id.tv_right_item);
            rlv_right = itemView.findViewById(R.id.rlv_right);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
