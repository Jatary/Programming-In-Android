package com.sdufe.thea.guo.view;

import com.nineoldandroids.view.ViewHelper;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class SlidingMenu extends HorizontalScrollView {

	private LinearLayout mWapper;
	private ViewGroup mMenu;
	private ViewGroup mContent;
	/**
	 * 屏幕宽度
	 */
	private int mSreenWidth;
	/**
	 * 菜单距离右侧的宽度,单位dp
	 */
	private int mMenuRightPadding=100;
	/**
	 * 菜单宽度
	 */
	private int mMenuWidth;
	/**
	 * 确定onMeasure只绘制一次
	 */
	private boolean once;

	public SlidingMenu(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		WindowManager windowManager = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics=new DisplayMetrics();
		windowManager.getDefaultDisplay().getMetrics(outMetrics);
		mSreenWidth=outMetrics.widthPixels;
		
		/**
		 * 把dp转化成px
		 */
		mMenuRightPadding = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 100, getResources()
						.getDisplayMetrics());
	}

	public SlidingMenu(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public SlidingMenu(Context context) {
		this(context, null);
	}
	/**
	 * 确定宽高
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		if (!once) {
			mWapper=(LinearLayout) getChildAt(0);
			mMenu=(ViewGroup) mWapper.getChildAt(0);
			mContent=(ViewGroup) mWapper.getChildAt(1);
			/**
			 * 菜单设置宽度
			 */
			mMenuWidth=mMenu.getLayoutParams().width=mSreenWidth-mMenuRightPadding;
			/**
			 * 内容设置宽度
			 */
			mContent.getLayoutParams().width=mSreenWidth;
			once=true;
		}
	}
	
	/**
	 * 设置偏移量,隐藏menu
	 */
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		super.onLayout(changed, l, t, r, b);
		if (changed) {
			/**
			 * 瞬间完成隐藏
			 */
			this.scrollTo(mMenuWidth, 0);
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
		case MotionEvent.ACTION_UP:
			/**
			 * 隐藏部分宽度
			 */
			int scroll=getScrollX();
			if (scroll>mMenuWidth/2) {
				/**
				 * 动画实现隐藏
				 */
				smoothScrollTo(mMenuWidth, 0);
			}else {
				/**
				 * 动画实现显示
				 */
				smoothScrollTo(0, 0);
			}
			return true;
		}
		return super.onTouchEvent(ev);
	}
	/**
	 * 通过onScrollChanged实现抽屉式滑动
	 */
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		
		ViewHelper.setTranslationX(mMenu, l);
	}
}
