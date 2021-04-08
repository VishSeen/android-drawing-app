package com.vish.apps.drawingsheet;

/**
 * Created by Vish on 12/10/2016.
 */

public class Points {
    int mX;
    int mY;

    private Points(){
    }

    public Points(int x, int y){
        mX = x;
        mY = y;
    }

    public int getX() {
        return mX;
    }

    public int getY() {
        return mY;
    }
}
