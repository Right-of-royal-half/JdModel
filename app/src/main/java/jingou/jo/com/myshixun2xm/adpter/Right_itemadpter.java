package jingou.jo.com.myshixun2xm.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import jingou.jo.com.myshixun2xm.Bean.FLrightBean;
import jingou.jo.com.myshixun2xm.R;

/**
 * Created by 杨杰 on 2017/12/15.
 */

public class Right_itemadpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<FLrightBean.DataBean.ListBean> list;
    public OnClickItemClick onClickItemClick;
    public interface OnClickItemClick{
       void onClickitem(int position);
    }

    public void setOnClickItemClick(OnClickItemClick onClickItemClick) {
        this.onClickItemClick = onClickItemClick;
    }

    public Right_itemadpter(Context context, List<FLrightBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.right_item_zh, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        final FLrightBean.DataBean.ListBean listBean = list.get(position);
        myViewHolder.sdv.setImageURI(listBean.getIcon());
        myViewHolder.tv.setText(listBean.getName());
        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onClickItemClick.onClickitem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sdv;
        private final TextView tv;
        private final LinearLayout ll;

        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sdv_zh);
            tv = itemView.findViewById(R.id.tv_zh);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
