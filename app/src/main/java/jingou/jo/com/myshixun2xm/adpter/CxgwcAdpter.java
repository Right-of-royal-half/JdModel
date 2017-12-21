package jingou.jo.com.myshixun2xm.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import jingou.jo.com.myshixun2xm.Bean.CxgwcBean;
import jingou.jo.com.myshixun2xm.MessageEvent;
import jingou.jo.com.myshixun2xm.PriceCountEvent;
import jingou.jo.com.myshixun2xm.R;

/**
 * Created by 杨杰 on 2017/12/20.
 */

public class CxgwcAdpter extends BaseExpandableListAdapter {
    private List<CxgwcBean.DataBean> grouplist;
    private List<List<CxgwcBean.DataBean.ListBean>> childlist;
    private Context context;
    private final LayoutInflater inflater;

    public CxgwcAdpter(List<CxgwcBean.DataBean> grouplist, List<List<CxgwcBean.DataBean.ListBean>> childlist, Context context) {
        this.grouplist = grouplist;
        this.childlist = childlist;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return grouplist.size();

    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childlist.get(groupPosition).size();

    }

    @Override
    public Object getGroup(int groupPosition) {
        return grouplist.get(groupPosition);

    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childlist.get(groupPosition).get(childPosition);

    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;

    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.gwcgroup_item, null);
        final CheckBox cb = view.findViewById(R.id.group_cb);
        TextView tv = view.findViewById(R.id.group_tv);
        final CxgwcBean.DataBean dataBean = grouplist.get(groupPosition);
        tv.setText(dataBean.getSellerName());
        //一级的checkbox
        cb.setChecked(dataBean.isOnchecked());
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBean.setOnchecked(cb.isChecked());
                changeChildState(groupPosition,cb.isChecked());
                EventBus.getDefault().post(compute());
                changeAllSelect(isAllGroup());
                notifyDataSetChanged();
            }
        });
        return view;

    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.gwcchild_item, null);
        final CxgwcBean.DataBean.ListBean listBean = childlist.get(groupPosition).get(childPosition);
        TextView tv1 = view.findViewById(R.id.child_tv1);
        tv1.setText(listBean.getCreatetime());
        TextView tv2 = view.findViewById(R.id.child_tv2);
        tv2.setText(listBean.getDetailUrl());
        final TextView price = view.findViewById(R.id.child_price);
        price.setText(listBean.getPrice() + "元");
        TextView tv3 = view.findViewById(R.id.child_tv3);
        tv3.setText(listBean.getDetailUrl());
        TextView iv_del = view.findViewById(R.id.iv_del);
        SimpleDraweeView sdv = view.findViewById(R.id.sdv);
        String images = listBean.getImages();
        String[] split = images.split("\\|");
        sdv.setImageURI(split+"");
        TextView iv_add = view.findViewById(R.id.iv_add);
        final TextView tv_num = view.findViewById(R.id.tv_num);
        tv_num.setText(listBean.getNum()+"");
        TextView tv_del = view.findViewById(R.id.tv_del);
        //点击全部子条目，主条目选中
        final CheckBox cb = view.findViewById(R.id.child_cb);
        //子条目点击事件
        cb.setChecked(listBean.isChecked());
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listBean.setChecked(cb.isChecked());
                PriceCountEvent priceandcountevent=compute();
                EventBus.getDefault().post(priceandcountevent);
                if (cb.isChecked()){
                    if (isAllChild(groupPosition)){
                        changGroupCbState(groupPosition,true);
                        changeAllSelect(isAllGroup());
                    }
                }else {
                    changGroupCbState(groupPosition,false);
                    changeAllSelect(isAllGroup());
                }
                notifyDataSetChanged();
            }
        });
        //加号
        iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = listBean.getNum();
                tv_num.setText(++num+"");
                listBean.setNum(num);
                if (cb.isChecked()){
                    PriceCountEvent priceCountEvent = compute();
                    EventBus.getDefault().post(priceCountEvent);
                }
            }
        });
        //减号
        iv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = listBean.getNum();
                if (num==1){
                    return;
                }
                tv_num.setText(--num+"");
                listBean.setNum(num);
                if (cb.isChecked()){
                    PriceCountEvent priceCountEvent = compute();
                    EventBus.getDefault().post(priceCountEvent);
                }
            }
        });
        //删除
        tv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<CxgwcBean.DataBean.ListBean> datasBeen = childlist.get(groupPosition);
                CxgwcBean.DataBean.ListBean remove = datasBeen.remove(childPosition);
                if (datasBeen.size()==0){
                    childlist.remove(groupPosition);
                    grouplist.remove(groupPosition);
                }
                EventBus.getDefault().post(compute());
                notifyDataSetChanged();
            }
        });
        return view;
    }


    //改变mainactivity里的全选按钮状态
    private void changeAllSelect(boolean flag){
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setChecked(flag);
        EventBus.getDefault().post(messageEvent);
    }
    /**
     * 改变一级列表checkbox状态
     *
     * @param groupPosition
     */
    private void changGroupCbState(int groupPosition, boolean flag) {
        CxgwcBean.DataBean dataBean = grouplist.get(groupPosition);
        dataBean.setOnchecked(flag);
    }
    /**
     * 改变二级列表checkbox状态
     *
     * @param groupPtions
     * @param flag
     */
    private void changeChildState(int groupPtions,boolean flag){
        List<CxgwcBean.DataBean.ListBean> datasBeen = childlist.get(groupPtions);
        for (int i=0;i<datasBeen.size();i++){
            CxgwcBean.DataBean.ListBean datas= datasBeen.get(i);
            datas.setChecked(flag);
        }
    }
    /**
     * 判断一级列表是否全部选中
     *
     * @return
     */
    private boolean isAllGroup() {
        for (int i = 0; i < grouplist.size(); i++) {
            CxgwcBean.DataBean dataBean = grouplist.get(i);
            if (!dataBean.isOnchecked()) {
                return false;
            }
        }
        return true;
    }
    //遍历二级列表，判断其他子布局是否全选中
    private boolean isAllChild(int groupPotion) {
        List<CxgwcBean.DataBean.ListBean> datasBeen = childlist.get(groupPotion);
        for (int i = 0; i < datasBeen.size(); i++) {
            CxgwcBean.DataBean.ListBean datas = datasBeen.get(i);
            if (!datas.isChecked()) {
                return false;
            }
        }
        return true;
    }

    //点击一级列表时，计算钱和数量
    private PriceCountEvent compute(){
        int count=0;
        int price=0;
        for (int i=0;i<childlist.size();i++){
            List<CxgwcBean.DataBean.ListBean> datasBeen = childlist.get(i);
            for (int j=0;j<datasBeen.size();j++){
                CxgwcBean.DataBean.ListBean datas = datasBeen.get(j);
                if (datas.isChecked()){
                    price+=datas.getNum()*datas.getPrice();
                    count+=datas.getNum();
                }
            }
        }

        PriceCountEvent priceCountEvent = new PriceCountEvent();
        priceCountEvent.setPrice(price);
        priceCountEvent.setCount(count);
        return priceCountEvent;
    }
    public void changeAllListState(boolean flag){
        for (int i=0;i<grouplist.size();i++){
            changGroupCbState(i,flag);
            changeChildState(i,flag);
        }
        EventBus.getDefault().post(compute());
        notifyDataSetChanged();

}

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
