package com.bing.mymvpdemo.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 禁止viewpager滑动
 * 
 * @author Administrator
 * 
 */
//LazyViewPager屏蔽ViewPager预加载操作的类
public class MyViewPager extends LazyViewPager {

	private boolean HAS_TOUCH_MODE = false;

	public MyViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public MyViewPager(Context context) {
		super(context);
	}
	
	//向内部控件传递
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		return false;
	}

	//不响应事件
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		return false;
	}
}
