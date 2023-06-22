package com.example.myroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class Customadapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<RoomInfomation> list;
    public Customadapter(Context context, int layout, List<RoomInfomation> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService((Context.LAYOUT_INFLATER_SERVICE));
        view=inflater.inflate(layout,null);
        TextView txttenroom=(TextView) view.findViewById(R.id.txttenphong);
        TextView txttennguoi=(TextView) view.findViewById(R.id.txttennguoithue);
        ImageView imghinh=(ImageView) view.findViewById(R.id.imghinh);
        RoomInfomation room=list.get(i);
        txttennguoi.setText(room.getHovaten());
        txttenroom.setText(room.getTenphong());
        imghinh.setImageResource(R.drawable.house1);
        return view;
    }
    public void updated()
    {
        notifyDataSetChanged();
    }
}
