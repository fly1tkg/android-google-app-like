package com.example.android_google_app_like.card_ui;

import android.app.ListActivity;
import android.os.Bundle;

public class CardUiActivity extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getListView().setDividerHeight(0);
        setListAdapter(new CardAdapater(this));
    }
}
