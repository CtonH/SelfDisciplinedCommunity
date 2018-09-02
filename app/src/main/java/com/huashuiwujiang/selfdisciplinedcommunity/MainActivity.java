package com.huashuiwujiang.selfdisciplinedcommunity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{

    private AppFragmentPagerAdapter fpAdapter;
    private ViewPager viewPager;

    private TextView btn_signin;
    private TextView btn_sche;
    private TextView btn_info;
    private TextView btn_mine;
    private Button btn_menu;



    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        fpAdapter=new AppFragmentPagerAdapter(getSupportFragmentManager());
        bindView();
        btn_signin.performClick();
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        btn_menu.setVisibility(View.GONE);
        switch(v.getId()){
            case R.id.button_sign_in:
                btn_menu.setVisibility(View.VISIBLE);
                setAllNotSelected();
                v.setSelected(true);
                viewPager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.button_schedule:
                btn_menu.setVisibility(View.VISIBLE);
                setAllNotSelected();
                v.setSelected(true);
                viewPager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.button_information:
                setAllNotSelected();
                v.setSelected(true);
                viewPager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.button_mine:
                setAllNotSelected();
                v.setSelected(true);
                viewPager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }

    /**
     * UI组件初始化和事件绑定
     */
    private void bindView(){
        btn_signin=findViewById(R.id.button_sign_in);
        btn_sche=findViewById(R.id.button_schedule);
        btn_info=findViewById(R.id.button_information);
        btn_mine=findViewById(R.id.button_mine);
        btn_menu=findViewById(R.id.button_menu);
        btn_signin.setOnClickListener(this);
        btn_sche.setOnClickListener(this);
        btn_info.setOnClickListener(this);
        btn_mine.setOnClickListener(this);
        btn_menu.setOnClickListener(this);

        viewPager=findViewById(R.id.view_pager);
        viewPager.setAdapter(fpAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);

    }

    /**
     * 设置所有四个底部栏按钮为未选择状态
     */
    private void setAllNotSelected(){
        btn_signin.setSelected(false);
        btn_sche.setSelected(false);
        btn_info.setSelected(false);
        btn_mine.setSelected(false);
    }

    /**
     * This method will be invoked when the current page is scrolled, either as part
     * of a programmatically initiated smooth scroll or a user initiated touch scroll.
     *
     * @param position             Position index of the first page currently being displayed.
     *                             Page position+1 will be visible if positionOffset is nonzero.
     * @param positionOffset       Value from [0, 1) indicating the offset from the page at position.
     * @param positionOffsetPixels Value in pixels indicating the offset from position.
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * This method will be invoked when a new page becomes selected. Animation is not
     * necessarily complete.
     *
     * @param position Position index of the new selected page.
     */
    @Override
    public void onPageSelected(int position) {

    }

    /**
     * Called when the scroll state changes. Useful for discovering when the user
     * begins dragging, when the pager is automatically settling to the current page,
     * or when it is fully stopped/idle.
     *
     * @param state The new scroll state.
     * @see ViewPager#SCROLL_STATE_IDLE
     * @see ViewPager#SCROLL_STATE_DRAGGING
     * @see ViewPager#SCROLL_STATE_SETTLING
     */
    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if(state==2){
            btn_menu.setVisibility(View.GONE);
            switch(viewPager.getCurrentItem()){
                case PAGE_ONE:
                    btn_menu.setVisibility(View.VISIBLE);
                    setAllNotSelected();
                    btn_signin.setSelected(true);
                    break;
                case PAGE_TWO:
                    btn_menu.setVisibility(View.VISIBLE);
                    setAllNotSelected();
                    btn_sche.setSelected(true);
                    break;
                case PAGE_THREE:
                    setAllNotSelected();
                    btn_info.setSelected(true);
                    break;
                case PAGE_FOUR:
                    setAllNotSelected();
                    btn_mine.setSelected(true);
                    break;
            }
        }
    }

}
