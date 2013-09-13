package com.example.android_google_app_like;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android_google_app_like.card_ui.CardUiActivity;
import com.example.android_google_app_like.navigation_drawer.NavigationDrawerActivity;
import com.example.android_google_app_like.swipe_to_dismiss.SwipeToDismissActivity;
import com.example.android_google_app_like.swipe_to_dismiss.SwipeToDismissWithUndoActivity;

public class MainActivity extends ListActivity {
    private static final ArrayList<Sample> SAMPLES = new ArrayList<Sample>() {
        {
            add(new Sample(NavigationDrawerActivity.class));
            add(new Sample(SwipeToDismissActivity.class));
            add(new Sample(SwipeToDismissWithUndoActivity.class));
            add(new Sample(CardUiActivity.class));
        }
    };

    private static final ArrayList<String> ITEMS = new ArrayList<String>() {
        {
            for (Sample sample : SAMPLES) {
                add(sample.name);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ITEMS));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Sample sample = SAMPLES.get(position);
        Intent i = new Intent(this, sample.clazz);
        startActivity(i);
    }
}
