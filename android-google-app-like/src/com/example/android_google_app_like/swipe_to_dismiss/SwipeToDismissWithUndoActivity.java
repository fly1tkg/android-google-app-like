package com.example.android_google_app_like.swipe_to_dismiss;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;

import com.example.android_google_app_like.swipe_to_dismiss.SwipeDismissList.UndoMode;

public class SwipeToDismissWithUndoActivity extends ListActivity {
    private static final ArrayList<String> ITEMS = new ArrayList<String>() {
        {
            for (int i = 0; i < 20; i++) {
                add("item" + i);
            }
        }
    };
    private ArrayAdapter<String> mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ITEMS);
        setListAdapter(mAdapter);
        SwipeDismissList.OnDismissCallback callback = new SwipeDismissList.OnDismissCallback() {
            // Gets called whenever the user deletes an item.
            public SwipeDismissList.Undoable onDismiss(AbsListView listView, final int position) {
                // Get your item from the adapter (mAdapter being an adapter for
                // MyItem objects)
                final String deletedItem = (String) mAdapter.getItem(position);
                // Delete item from adapter
                mAdapter.remove(deletedItem);
                // Return an Undoable implementing every method
                return new SwipeDismissList.Undoable() {

                    // Method is called when user undoes this deletion
                    public void undo() {
                        // Reinsert item to list
                        mAdapter.insert(deletedItem, position);
                    }

                    // Return an undo message for that item
                    public String getTitle() {
                        return deletedItem.toString() + " deleted";
                    }

                    // Called when user cannot undo the action anymore
                    public void discard() {
                        // Use this place to e.g. delete the item from database
                        // finallyDeleteFromSomeStorage(deletedItem);
                    }
                };
            }
        };
        new SwipeDismissList(getListView(), callback, UndoMode.COLLAPSED_UNDO);
    }
}
