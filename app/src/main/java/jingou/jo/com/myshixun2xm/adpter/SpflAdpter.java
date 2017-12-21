package jingou.jo.com.myshixun2xm.adpter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import jingou.jo.com.myshixun2xm.Bean.Flzflbean;
import jingou.jo.com.myshixun2xm.R;

/**
 * Created by 杨杰 on 2017/12/17.
 */

public class SpflAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Flzflbean.DataBean> list;
    private Context context;
    OnClickfl onClickfl;
    public interface OnClickfl{
        void onClickxq(int position);
    }

    public void setOnclickSpflAdpter(OnClickfl onClickfl) {
        this.onClickfl = onClickfl;
    }

    public SpflAdpter(List<Flzflbean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.spfl_item, parent, false);
        return new MyViewHoler(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHoler myViewHoler = (MyViewHoler) holder;
        Flzflbean.DataBean dataBean = list.get(position);
        myViewHoler.name.setText(dataBean.getSubhead());
        myViewHoler.price.setText("¥" + dataBean.getPrice() + ".00");
        String images = dataBean.getImages();
        String[] split = images.split("\\|");
            myViewHoler.sdv.setImageURI(Uri.parse(split[1]));
       myViewHoler.ll.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int pid = list.get(position).getPid();
               onClickfl.onClickxq(pid);
           }
       });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHoler extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sdv;
        private final TextView name;
        private final TextView price;
        private final LinearLayout ll;

        public MyViewHoler(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.spfl_sdv_item);
            name = itemView.findViewById(R.id.spfl_tv);
            price = itemView.findViewById(R.id.price_tv);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
