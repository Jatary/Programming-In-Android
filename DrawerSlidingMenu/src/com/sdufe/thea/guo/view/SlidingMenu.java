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
	 * ��Ļ���
	 */
	private int mSreenWidth;
	/**
	 * �˵������Ҳ�Ŀ��,��λdp
	 */
	private int mMenuRightPadding=100;
	/**
	 * �˵����
	 */
	private int mMenuWidth;
	/**
	 * ȷ��onMeasureֻ����һ��
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
		 * ��dpת����px
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
	 * ȷ�����
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		if (!once) {
			mWapper=(LinearLayout) getChildAt(0);
			mMenu=(ViewGroup) mWapper.getChildAt(0);
			mContent=(ViewGroup) mWapper.getChildAt(1);
			/**
			 * �˵����ÿ��
			 */
			mMenuWidth=mMenu.getLayoutParams().width=mSreenWidth-mMenuRightPadding;
			/**
			 * �������ÿ��
			 */
			mContent.getLayoutParams().width=mSreenWidth;
			once=true;
		}
	}
	
	/**
	 * ����ƫ����,����menu
	 */
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		super.onLayout(changed, l, t, r, b);
		if (changed) {
			/**
			 * ˲���������
			 */
			this.scrollTo(mMenuWidth, 0);
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
		case MotionEvent.ACTION_UP:
			/**
			 * ���ز��ֿ��
			 */
			int scroll=getScrollX();
			if (scroll>mMenuWidth/2) {
				/**
				 * ����ʵ������
				 */
				smoothScrollTo(mMenuWidth, 0);
			}else {
				/**
				 * ����ʵ����ʾ
				 */
				smoothScrollTo(0, 0);
			}
			return true;
		}
		return super.onTouchEvent(ev);
	}
	/**
	 * ͨ��onScrollChangedʵ�ֳ���ʽ����
	 */
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		
		ViewHelper.setTranslationX(mMenu, l);
	}
}
