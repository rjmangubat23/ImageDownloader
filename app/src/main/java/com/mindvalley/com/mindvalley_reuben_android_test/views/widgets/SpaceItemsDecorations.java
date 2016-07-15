package com.mindvalley.com.mindvalley_reuben_android_test.views.widgets;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by rjmangubat on 15/07/16.
 */
public class SpaceItemsDecorations extends RecyclerView.ItemDecoration {
    private final int mSpace;

    public SpaceItemsDecorations(int space) {
        this.mSpace = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = mSpace;
        outRect.right = mSpace;
        outRect.bottom = mSpace;

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildAdapterPosition(view) == 0)
            outRect.top = mSpace;
    }
}
