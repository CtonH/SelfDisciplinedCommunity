package com.huashuiwujiang.selfdisciplinedcommunity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class AppFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT=4;

    private AppFragment signFg,scheFg,mineFg,infoFg;

    public AppFragmentPagerAdapter(FragmentManager fm){
        super(fm);
        signFg=new AppFragment();
        signFg.setLayoutResID(R.layout.page_signin);
        scheFg=new AppFragment();
        scheFg.setLayoutResID(R.layout.page_schedule);
        infoFg=new AppFragment();
        infoFg.setLayoutResID(R.layout.page_information);
        mineFg=new AppFragment();
        mineFg.setLayoutResID(R.layout.page_mine);
    }

    @Override
    public int getCount(){
        return PAGER_COUNT;
    }

    @Override
    public Fragment getItem(int position){
        Fragment fg=null;
        switch (position){
            case MainActivity.PAGE_ONE:
                fg=signFg;
                break;
            case MainActivity.PAGE_TWO:
                fg=scheFg;
                break;
            case MainActivity.PAGE_THREE:
                fg=infoFg;
                break;
            case MainActivity.PAGE_FOUR:
                fg=mineFg;
                break;
        }
        return fg;
    }


}
