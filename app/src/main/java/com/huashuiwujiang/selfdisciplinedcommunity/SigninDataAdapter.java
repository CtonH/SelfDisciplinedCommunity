package com.huashuiwujiang.selfdisciplinedcommunity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SigninDataAdapter extends BaseAdapter {

    private ArrayList<SigninData> data;
    private Context context;

    public SigninDataAdapter(ArrayList<SigninData> data,Context context){
        this.data=data;
        this.context=context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.item_list_view_signin,parent,false);

        TextView txt_title=convertView.findViewById(R.id.text_view_signin_title);
        TextView txt_date=convertView.findViewById(R.id.text_view_signin_date);
        TextView txt_place=convertView.findViewById(R.id.text_view_signin_place);

        txt_title.setText(data.get(position).getTitle());
        String date_format= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss E a ").format(data.get(position).getDate());
        txt_date.setText(date_format);
        txt_place.setText(data.get(position).getPlace());

        return convertView;
    }
}
