package com.huashuiwujiang.selfdisciplinedcommunity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class AppFragment extends Fragment {

    private int layoutResID;

    private ArrayList<SigninData> data_signin;

    /**
     * 设置fragment的布局文件
     * @param layoutResID 布局文件ID
     */

    public void setLayoutResID(int layoutResID){
        this.layoutResID=layoutResID;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view= inflater.inflate(layoutResID,container,false);

        switch (layoutResID){
            case R.layout.page_signin:
                data_signin=getSigninData();
                SigninDataAdapter adapter=new SigninDataAdapter( data_signin,getActivity());
                ((ListView)view.findViewById(R.id.list_view_signin)).setAdapter(adapter);

        }
        return view;
    }

    /**
     * 获取打卡的数据
     * @return 打卡的数据
     */
    private ArrayList<SigninData> getSigninData(){
        ArrayList<SigninData> data=new ArrayList<>();
        data.add(new SigninData("学习",new Date(),"图书馆"));
        data.add(new SigninData("跑步",new Date(),"华南农业大学华山区运动场"));
        data.add(new SigninData("背单词",new Date(),"图书馆"));

        return data;
    }
}
