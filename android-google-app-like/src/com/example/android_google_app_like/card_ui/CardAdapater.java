package com.example.android_google_app_like.card_ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;

import com.example.android_google_app_like.R;

public class CardAdapater extends ArrayAdapter<Void> {
    private static final int SIZE = 30;
    private static final Void[] ITEMS = new Void[SIZE];
    private static final int LAYOUTID = R.layout.listitem_card;
    private LayoutInflater mInflater;
    private int mAnimatedPosition;

    public CardAdapater(Context context) {
        super(context, 0, ITEMS);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = mInflater.inflate(LAYOUTID, null);
        }

        if (mAnimatedPosition < position) {
            Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.bottom_to_up);
            view.startAnimation(animation);
            mAnimatedPosition = position;
        }

        return view;
    }

}
