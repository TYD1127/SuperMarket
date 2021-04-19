package com.tyd.supermarket;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
public class myadapter extends BaseAdapter {
    private List<dxl> list;
    private LayoutInflater layoutInflater;
    public myadapter(Context context, List<dxl> list){
        this.layoutInflater = LayoutInflater.from(context);
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=layoutInflater.inflate(R.layout.list,null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        dxl dxl = list.get(position);
        viewHolder.tv_name.setText("商品名称："+dxl.getName());
        viewHolder.tv_price.setText("商品价格："+dxl.getPrice()+"元");
        viewHolder.tv_number.setText("商品数量："+dxl.getNumber());
        Log.e("yanwenhua","cartBean.getName()-"+dxl.getName()+"  "+dxl.getPrice()+"  "+dxl.getNumber());
        return convertView;
    }
    class ViewHolder{
        TextView tv_name;
        TextView tv_price;
        TextView tv_number;
        public ViewHolder(View view){
            tv_name = view.findViewById(R.id.tv_name);
            tv_price = view.findViewById(R.id.tv_price);
            tv_number = view.findViewById(R.id.tv_number);
        }
    }

}