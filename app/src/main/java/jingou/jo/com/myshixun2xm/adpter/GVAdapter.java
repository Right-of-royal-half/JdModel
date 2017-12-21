package jingou.jo.com.myshixun2xm.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import jingou.jo.com.myshixun2xm.Bean.FlleftBean;
import jingou.jo.com.myshixun2xm.R;

/**
 * Created by 杨杰 on 2017/12/14.
 */

public class GVAdapter extends BaseAdapter{
    private List<FlleftBean.DataBean> list;
    private Context context;
    private LayoutInflater inflater;

    public GVAdapter(List<FlleftBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        if (convertView==null){
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.vipfragment_item,null);
            holder.sdv = view.findViewById(R.id.sdv);
            holder.tv = view.findViewById(R.id.tv);
            view.setTag(holder);
        }else{
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.sdv.setImageURI(list.get(position).getIcon());
        holder.tv.setText(list.get(position).getName());
        return view;
    }
    class ViewHolder{
        TextView tv;
        SimpleDraweeView sdv;
    }
}
